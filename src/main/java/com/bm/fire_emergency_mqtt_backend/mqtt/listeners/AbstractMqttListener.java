package com.bm.fire_emergency_mqtt_backend.mqtt.listeners;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractMqttListener {

    private final IMqttClient mqttClient;
    Logger logger = LoggerFactory.getLogger(AbstractMqttListener.class);

    public AbstractMqttListener(IMqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    protected void listener() {
        try {
            mqttClient.subscribe("mqtt", ((topic, message) -> {
                logger.info("--> The Mqtt server is being listened: ", message);
            }));
        } catch (MqttException e) {
            logger.error("--> The Mqtt server threw an exception: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
