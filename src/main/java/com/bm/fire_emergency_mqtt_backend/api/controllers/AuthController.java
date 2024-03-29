package com.bm.fire_emergency_mqtt_backend.api.controllers;

import com.bm.fire_emergency_mqtt_backend.api.dto.auth.LoginDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.auth.RegisterDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.auth.TokenDto;
import com.bm.fire_emergency_mqtt_backend.business.services.AuthService;
import com.bm.fire_emergency_mqtt_backend.core.concerns.security.jwt.token.Token;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.bm.fire_emergency_mqtt_backend.api.convertors.AuthConvertor.*;

@RestController
@RequestMapping("api/auth")
public class AuthController extends BaseController {

    private final AuthService authService;
    private final HttpServletRequest request;


    public AuthController(AuthService authService, HttpServletRequest request) {
        this.authService = authService;
        this.request = request;
    }

    @PostMapping("login")
    public ResponseEntity<DataResult<TokenDto>> login(@RequestBody LoginDto loginDto) {
        DataResult<Token> result = authService.login(loginDto);
        if (result.isSuccess())
            return new ResponseEntity<>(
                    new SuccessDataResult<>(
                            convertTokenToTokenDto(result.getData()),
                            result.getMessage()
                    ),
                    HttpStatus.OK
            );

        return new ResponseEntity<>(
                new ErrorDataResult<>(null, result.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @PostMapping("register")
    public ResponseEntity<DataResult<TokenDto>> register(@RequestBody RegisterDto registerDto) {
        DataResult<Token> result = authService.register(registerDto);
        if (result.isSuccess())
            return new ResponseEntity<>(
                    new SuccessDataResult<>(
                            convertTokenToTokenDto(result.getData()), result.getMessage()),
                    HttpStatus.CREATED);

        return new ResponseEntity<>(
                new ErrorDataResult<>(null, result.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @GetMapping("isLoggedIn")
    public ResponseEntity<DataResult<TokenDto>> isLoggedIn() {
        String token = request.getHeader("Authorization");
        if (token == null)
            return new ResponseEntity<>(new ErrorDataResult<>(null, "Token is null"), HttpStatus.UNAUTHORIZED);
        DataResult<Token> result = authService.isLoggedIn(token);
        if (result.isSuccess())
            return new ResponseEntity<>(
                    new SuccessDataResult<>(
                            convertTokenToTokenDto(result.getData()), result.getMessage()),
                    HttpStatus.OK
            );

        return new ResponseEntity<>(
                new ErrorDataResult<>(null, result.getMessage()),
                HttpStatus.UNAUTHORIZED);
    }

}
