package com.bm.fire_emergency_mqtt_backend.api.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterDto {

    @JsonProperty("password")
    private String password;
    @JsonProperty("confirmationPassword")
    private String confirmationPassword;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
}
