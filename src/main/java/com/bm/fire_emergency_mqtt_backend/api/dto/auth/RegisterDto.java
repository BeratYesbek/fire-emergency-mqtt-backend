package com.bm.fire_emergency_mqtt_backend.api.dto.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterDto {
    private String password;
    private String confirmationPassword;
    private String fullName;
    private String username;
    private String email;
}
