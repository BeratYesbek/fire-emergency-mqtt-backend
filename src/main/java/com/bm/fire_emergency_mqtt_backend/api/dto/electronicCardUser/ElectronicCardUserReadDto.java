package com.bm.fire_emergency_mqtt_backend.api.dto.electronicCardUser;

import com.bm.fire_emergency_mqtt_backend.api.dto.user.UserReadDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter
@Builder
public class ElectronicCardUserReadDto {
    private int id;
    private Date createdAt;
    private String name;
    private String uuid;
    private UserReadDto user;
}
