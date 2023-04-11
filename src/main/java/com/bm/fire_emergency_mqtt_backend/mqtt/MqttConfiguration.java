package com.bm.fire_emergency_mqtt_backend.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.UUID;

@Configuration
public class MqttConfiguration {

    String publisherId = UUID.randomUUID().toString();
    IMqttClient publisher;
    MqttConnectOptions options;

    @Bean
    public IMqttClient mqttClient() throws MqttException {
        publisher = new MqttClient("tcp://localhost:1883", publisherId);
        options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        options.setPassword("admin".toCharArray());
        options.setUserName("admin");
        publisher.connect(options);
        return publisher;
    }


}
