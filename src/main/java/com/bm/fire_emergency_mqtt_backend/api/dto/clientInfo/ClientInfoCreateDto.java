package com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClientInfoCreateDto {
    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("phoneName")
    private String phoneName = "sadasd";

    @JsonProperty("phoneBrand")
    private String phoneBrand = "sadasd";

    @JsonProperty("operatingSystem")
    private String operatingSystem;

    @JsonProperty("token")
    private String token;

    @JsonProperty("phoneUUID")
    private String phoneUUID = "sadasd";

    @JsonProperty("userId")
    private int userId;
}
