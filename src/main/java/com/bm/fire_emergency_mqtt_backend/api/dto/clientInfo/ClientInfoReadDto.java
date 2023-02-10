package com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo;

import com.bm.fire_emergency_mqtt_backend.api.dto.user.UserReadDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class ClientInfoReadDto {
    private int id;
    private double latitude;
    private double longitude;
    private String phoneName;
    private String phoneBrand;
    private String operatingSystem;
    private String phoneUUID;
    private UserReadDto userReadDto;
    private Date createdAt;
}
