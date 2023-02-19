package com.bm.fire_emergency_mqtt_backend.data;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbGasSensorLog;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;

import java.util.Date;

public final class StaticDbEntitiesData {
    private StaticDbEntitiesData() {

    }

    public static final DbUser dbUser = DbUser.builder()
            .email("berat@gmail.com")
            .fullName("berat yesbek")
            .password("123456")
            .username("feanor")
            .build();

    public static final DbClientInfo clientInfo = DbClientInfo.builder()
            .dbUser(dbUser)
            .phoneName("BERAT Samsung Galaxy S21 FE")
            .phoneBrand("Samsung Galaxy S21 FE")
            .operatingSystem("Android 12")
            .latitude(23.56455645)
            .longitude(43.6545464)
            .build();


    public static final DbGasSensorLog gasSensorLog = DbGasSensorLog.builder()
            .detectionGas("example")
            .sensorType("example-A32")
            .concentration("example")
            .modelNo("example-541DA")
            .heaterVoltage("12V")
            .loadResistance("example")
            .loopVoltage("6V")
            .preheatTime(new Date())
            .sensingResistance("example")
            .sensitivity("example")
            .slope("A+")
            .heaterConsumption("example")
            .temHumidity("example")
            .detectionGas("example")
            .standardTestCircuit("example").build();
}
