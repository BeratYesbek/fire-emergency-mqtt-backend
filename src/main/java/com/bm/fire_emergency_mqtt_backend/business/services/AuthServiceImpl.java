package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.api.dto.auth.LoginDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.auth.RegisterDto;
import com.bm.fire_emergency_mqtt_backend.business.rules.AuthRules;
import com.bm.fire_emergency_mqtt_backend.core.invokes.BusinessRules;
import com.bm.fire_emergency_mqtt_backend.core.concerns.security.encryption.PasswordHelper;
import com.bm.fire_emergency_mqtt_backend.core.concerns.security.jwt.JwtHelper;
import com.bm.fire_emergency_mqtt_backend.core.concerns.security.jwt.token.Token;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.AuthMessages.*;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final UserRoleService userRoleService;
    private final JwtHelper jwtHelper;

    public AuthServiceImpl(UserService userService, UserRoleService userRoleService, JwtHelper jwtHelper) {
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public DataResult<Token> login(LoginDto loginDto) {
        DataResult<DbUser> dbUserDataResult = null;
        if (loginDto.getUsername() != null)
            dbUserDataResult = userService.findByUsername(loginDto.getUsername());
        else if (loginDto.getEmail() != null)
            dbUserDataResult = userService.findByEmail(loginDto.getEmail());
        if (!dbUserDataResult.isSuccess())
            return new ErrorDataResult<>(null, dbUserDataResult.getMessage());
        boolean result = PasswordHelper.verifyPassword(loginDto.getPassword(), dbUserDataResult.getData().getPassword());
        if (result) {
            List<String> roles = userRoleService.findUserRoleByUserId(
                    dbUserDataResult.getData().getId()).getData().stream().map(item ->
                    item.getDbRole().getName()).collect(Collectors.toList());
            Token token = jwtHelper.createToken(dbUserDataResult.getData(), roles.toArray(String[]::new), "");
            token.setUser(dbUserDataResult.getData());
            return new SuccessDataResult<>(token, USER_LOGGED_IN);
        }

        return new ErrorDataResult<>(null, INVALID_CREDENTIALS);
    }

    @Override
    public DataResult<Token> register(RegisterDto registerDto) {
        Result ruleResult = BusinessRules.run(
                AuthRules.checkEmailHasSomeoneElse(registerDto.getEmail(), userService),
                AuthRules.checkUsernameHasSomeoneElse(registerDto.getUsername(), userService)
        );
        if (!ruleResult.isSuccess()) {
            return new ErrorDataResult<>(null, ruleResult.getMessage());
        }
        // TODO must be validation before inserts
        final DbUser dbUser = DbUser.builder()
                .email(registerDto.getEmail())
                .username(registerDto.getUsername())
                .fullName(registerDto.getFullName())
                .password(PasswordHelper.hashPassword(registerDto.getPassword())).build();
        DataResult<DbUser> dbUserDataResult = userService.create(dbUser);
        if (!dbUserDataResult.isSuccess())
            return new ErrorDataResult<>(null, dbUserDataResult.getMessage());
        DbUserRole dbUserRole = DbUserRole.builder()
                .dbUser(dbUser)
                .build();

        userRoleService.createDefaultRole(dbUserRole);
        List<String> roles = userRoleService.findUserRoleByUserId(dbUser.getId()).getData().stream().map(item ->
                item.getDbRole().getName()).collect(Collectors.toList());
        Token token = jwtHelper.createToken(dbUser, roles.toArray(String[]::new), "");
        token.setUser(dbUser);
        return new SuccessDataResult<>(token, USER_CREATED);
    }

    @Override
    public DataResult<Token> isLoggedIn(String token) {
        DataResult<Token> dataResult = jwtHelper.validateToken(token);
        if (dataResult.isSuccess()) {
            DbUser dbUser = userService.findByUsername(dataResult.getData().getUser().getUsername()).getData();
            dataResult.getData().setUser(dbUser);
            return dataResult;
        }
        return dataResult;
    }


}
