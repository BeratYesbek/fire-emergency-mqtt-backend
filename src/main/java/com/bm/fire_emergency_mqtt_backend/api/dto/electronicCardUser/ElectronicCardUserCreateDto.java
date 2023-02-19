package com.bm.fire_emergency_mqtt_backend.api.dto.electronicCardUser;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class ElectronicCardUserCreateDto {

    @JsonProperty("name")
    private String name;

    //TODO --> dbUser has to remove in the future
    @JsonProperty("user")
    private DbUser user;
}
