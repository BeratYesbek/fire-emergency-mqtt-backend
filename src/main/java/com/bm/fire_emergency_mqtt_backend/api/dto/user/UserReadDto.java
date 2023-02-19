package com.bm.fire_emergency_mqtt_backend.api.dto.user;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class UserReadDto {
    private int id;
    private String email;
    private String username;
    private String fullName;
    private Date createdAt;
}
