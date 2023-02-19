package com.bm.fire_emergency_mqtt_backend.api.convertors;

import com.bm.fire_emergency_mqtt_backend.api.dto.user.UserReadDto;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;

public final class UserConvertor {

    private UserConvertor() {

    }

    public static UserReadDto convertDbUserToUserReadDto(DbUser dbUser) {
        return UserReadDto.builder()
                .id(dbUser.getId())
                .email(dbUser.getEmail())
                .fullName(dbUser.getFullName())
                .username(dbUser.getUsername())
                .createdAt(dbUser.getCreatedAt())
                .build();
    }
}
