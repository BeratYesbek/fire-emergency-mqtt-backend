package com.bm.fire_emergency_mqtt_backend.api.convertors;

import com.bm.fire_emergency_mqtt_backend.api.dto.auth.TokenDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.user.UserReadDto;
import com.bm.fire_emergency_mqtt_backend.core.security.jwt.token.Token;

public final class AuthConvertor {

    private AuthConvertor() {

    }
    
    public static TokenDto convertTokenToTokenDto(Token token) {
        return TokenDto.builder()
                .accessToken(token.getAccessToken())
                .expiry(token.getExpiry())
                .user(
                        UserReadDto.builder()
                                .id(token.getUser().getId())
                                .email(token.getUser().getEmail())
                                .fullName(token.getUser().getFullName())
                                .username(token.getUser().getUsername())
                                .createdAt(token.getUser().getCreatedAt())
                                .build()
                ).build();
    }
}
