package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.api.dto.auth.LoginDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.auth.RegisterDto;
import com.bm.fire_emergency_mqtt_backend.core.security.jwt.token.Token;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;

public interface AuthService {
    DataResult<Token> login(LoginDto loginDto);

    DataResult<Token> register(RegisterDto registerDto);
}
