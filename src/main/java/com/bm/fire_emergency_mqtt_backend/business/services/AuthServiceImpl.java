package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.api.dto.auth.LoginDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.auth.RegisterDto;
import com.bm.fire_emergency_mqtt_backend.business.rules.AuthRules;
import com.bm.fire_emergency_mqtt_backend.core.invokes.BusinessRules;
import com.bm.fire_emergency_mqtt_backend.core.security.encryption.PasswordHelper;
import com.bm.fire_emergency_mqtt_backend.core.security.jwt.JwtHelper;
import com.bm.fire_emergency_mqtt_backend.core.security.jwt.token.Token;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUserRole;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.AuthMessages.USER_CREATED;

@Service
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
        return null;
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
}
