package com.bm.fire_emergency_mqtt_backend.mqtt.listeners;

import com.bm.fire_emergency_mqtt_backend.core.annotations.MqttListener;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import static com.bm.fire_emergency_mqtt_backend.mqtt.constants.MqttConstants.URGENT;

@MqttListener(name = "UrgentListener")
public class MqttUrgentListener extends AbstractMqttListener {

    private final IMqttClient mqttClient;
    public MqttUrgentListener(IMqttClient mqttClient) {
        super(mqttClient);
        this.mqttClient = mqttClient;
    }

    @Override
    protected void listener() {
        try {
            mqttClient.subscribe(URGENT, ((topic, message) -> {
                    // TODO business logic
            }));
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
        super.listener();
    }
}
