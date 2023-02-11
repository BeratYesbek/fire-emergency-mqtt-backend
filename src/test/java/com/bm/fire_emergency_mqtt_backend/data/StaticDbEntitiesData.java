package com.bm.fire_emergency_mqtt_backend.data;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;

public final class StaticDbEntitiesData {
    private StaticDbEntitiesData() {

    }

    public static DbUser dbUser = DbUser.builder()
            .email("berat@gmail.com")
            .fullName("berat yesbek")
            .password("123456")
            .username("feanor")
            .build();

    public static DbClientInfo clientInfo = DbClientInfo.builder()
            .dbUser(dbUser)
            .phoneName("BERAT Samsung Galaxy S21 FE")
            .phoneUUID("c939baa8-a578-11ed-b9df-0242ac120003")
            .phoneBrand("Samsung Galaxy S21 FE")
            .latitude(23.56455645)
            .longitude(43.6545464)
            .build();
}
