package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.api.dto.auth.LoginDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.auth.RegisterDto;
import com.bm.fire_emergency_mqtt_backend.business.rules.AuthRules;
import com.bm.fire_emergency_mqtt_backend.core.invokes.BusinessRules;
import com.bm.fire_emergency_mqtt_backend.core.security.encryption.PasswordHelper;
import com.bm.fire_emergency_mqtt_backend.core.security.jwt.token.Token;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;

public class AuthServiceImpl implements AuthService {

    private final UserService userService;

    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
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
        DbUser dbUser = DbUser.builder()
                .email(registerDto.getEmail())
                .username(registerDto.getUsername())
                .fullName(registerDto.getFullName())
                .password(PasswordHelper.hashPassword(registerDto.getPassword())).build();

        // TODO continue other process

        return null;
    }
}
