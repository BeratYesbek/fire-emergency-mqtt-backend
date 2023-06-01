package com.bm.fire_emergency_mqtt_backend.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

import java.net.ConnectException;

import static com.bm.fire_emergency_mqtt_backend.mqtt.constants.MqttConstants.COMMAND;


@Service
public class MqttCommandSenderImpl implements MqttMessageSender<Command> {
    private final IMqttClient mqttClient;
    private Command command;
    private String topic;

    public MqttCommandSenderImpl(IMqttClient mqttClient) {
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
        String fullTopic = String.format("%s: %s", COMMAND, topic);
        mqttClient.publish(fullTopic, msg);
        return null;
    }

    private MqttMessage readMessage() {
        byte[] payload = command.name().getBytes();
        return new MqttMessage(payload);
    }

    @Override
    public void setValue(Command value) {
        command = value;
    }

    @Override
    public void setTopic(String value) {
        topic = value;
    }
}
