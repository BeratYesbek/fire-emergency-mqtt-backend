package com.bm.fire_emergency_mqtt_backend.api.controllers;

import com.bm.fire_emergency_mqtt_backend.api.dto.auth.RegisterDto;
import com.bm.fire_emergency_mqtt_backend.business.services.AuthService;
import com.bm.fire_emergency_mqtt_backend.core.security.jwt.token.Token;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("register")
    public ResponseEntity<DataResult<Token>> register(@RequestBody RegisterDto registerDto) {
        DataResult<Token> result = authService.register(registerDto);
        if (result.isSuccess())
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
