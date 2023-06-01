package com.bm.fire_emergency_mqtt_backend.api.controllers;


import com.bm.fire_emergency_mqtt_backend.api.dto.CommandDto;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessResult;
import com.bm.fire_emergency_mqtt_backend.mqtt.MqttMessageSender;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("api/commands")
public class CommandsController {

    private final MqttMessageSender mqttMessageSender;

    public CommandsController(@Qualifier("mqttCommandSenderImpl") MqttMessageSender mqttMessageSender) {
        this.mqttMessageSender = mqttMessageSender;
    }

    @PostMapping
    public ResponseEntity<Result> send(@RequestBody CommandDto commandDto) {
        mqttMessageSender.setValue(commandDto.getCommand());
        mqttMessageSender.setTopic(commandDto.getCardId());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(mqttMessageSender);
        executorService.shutdown();
        return new ResponseEntity<>(new SuccessResult("Command Sent"), HttpStatus.OK);
    }
}
