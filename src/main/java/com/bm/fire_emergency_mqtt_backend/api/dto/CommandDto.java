package com.bm.fire_emergency_mqtt_backend.api.dto;


import com.bm.fire_emergency_mqtt_backend.mqtt.Command;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CommandDto {
    private Command command;
    private String cardId;
}
