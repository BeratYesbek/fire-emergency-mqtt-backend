package com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateClientInfoColumnConstants.*;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateCommonColumnConstants.COL_ID;

@Getter
@Setter
public class CreateClientInfoDto {
    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("phoneName")
    private String phoneName;

    @JsonProperty("phoneBrand")
    private String phoneBrand;

    @JsonProperty("operatingSystem")
    private String operatingSystem;

    @JsonProperty("phoneUUID")
    private String phoneUUID;

    //TODO --> dbUser has to remove in the future
    @JsonProperty("dbUser")
    private DbUser dbUser;
}
