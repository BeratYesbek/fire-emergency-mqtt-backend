package com.bm.fire_emergency_mqtt_backend.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

import java.net.ConnectException;

import static org.springframework.integration.mqtt.support.MqttHeaders.TOPIC;

@Service
public class MqttMessageSenderImpl implements MqttMessageSender{

    private final IMqttClient mqttClient;

    public MqttMessageSenderImpl(IMqttClient mqttClient) {
        this.mqttClient = mqttClient;
    }

    @Override
    public Void call() throws Exception {
        if (!mqttClient.isConnected()) {
            throw new ConnectException("Mqtt server is not running");
        }
        MqttMessage msg = readMessage();
        msg.setQos(0);
        msg.setRetained(true);
        mqttClient.publish(TOPIC,msg);
        return null;
    }

    private MqttMessage readMessage() {
        byte[] payload = "Hello, Mqtt Client".getBytes();
        return new MqttMessage(payload);
    }
}
