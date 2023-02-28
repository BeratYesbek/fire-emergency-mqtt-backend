package com.bm.fire_emergency_mqtt_backend.api.dto.auth;

import com.bm.fire_emergency_mqtt_backend.api.dto.user.UserReadDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class TokenDto {
    private UserReadDto user;

    private String accessToken;

    private Date expiry;
}
