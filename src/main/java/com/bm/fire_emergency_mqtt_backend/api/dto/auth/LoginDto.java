package com.bm.fire_emergency_mqtt_backend.api.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginDto {
    private String email;
    private String password;
}
