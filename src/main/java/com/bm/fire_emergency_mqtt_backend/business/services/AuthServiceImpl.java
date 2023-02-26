package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.api.dto.auth.LoginDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.auth.RegisterDto;
import com.bm.fire_emergency_mqtt_backend.core.security.jwt.token.Token;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;

public class AuthServiceImpl implements AuthService {


    @Override
    public DataResult<Token> login(LoginDto loginDto) {
        return null;
    }

    @Override
    public DataResult<Token> register(RegisterDto registerDto) {
        return null;
    }
}
