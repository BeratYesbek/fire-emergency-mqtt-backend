package com.bm.fire_emergency_mqtt_backend.api.dto.gasSensorLog;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CreateGasSensorLogDto {

    @JsonProperty("modelNo")
    private String modelNo;

    @JsonProperty("sensorType")
    private String sensorType;

    @JsonProperty("detectionGas")
    private String detectionGas;

    @JsonProperty("concentration")
    private String concentration;

    @JsonProperty("loopVoltage")
    private String loopVoltage;

    @JsonProperty("heaterVoltage")
    private String heaterVoltage;

    @JsonProperty("loadResistance")
    private String loadResistance;

    @JsonProperty("heaterConsumption")
    private String heaterConsumption;

    @JsonProperty("sensingResistance")
    private String sensingResistance;

    @JsonProperty("sensitivity")
    private String sensitivity;

    @JsonProperty("slope")
    private String slope;

    @JsonProperty("temHumidity")
    private String temHumidity;

    @JsonProperty("standardTestCircuit")
    private String standardTestCircuit;
}
