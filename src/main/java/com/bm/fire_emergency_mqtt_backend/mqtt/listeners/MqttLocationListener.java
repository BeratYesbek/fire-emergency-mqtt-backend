package com.bm.fire_emergency_mqtt_backend.mqtt.listeners;

import com.bm.fire_emergency_mqtt_backend.business.services.LocationService;
import com.bm.fire_emergency_mqtt_backend.core.annotations.MqttListener;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbLocation;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.concurrent.CompletableFuture;

import static com.bm.fire_emergency_mqtt_backend.mqtt.constants.MqttConstants.LOCATION;


@MqttListener(name = "LocationListener")
public class MqttLocationListener extends AbstractMqttListener {

    private final IMqttClient mqttClient;
    private final LocationService locationService;
    private final Logger logger = LoggerFactory.getLogger(MqttLocationListener.class);

    public MqttLocationListener(IMqttClient mqttClient, LocationService locationService) {
        super(mqttClient);
        this.mqttClient = mqttClient;
        this.locationService = locationService;
        CompletableFuture.runAsync(this::listener);
    }


    @Override
    protected void listener() {
        try {
            mqttClient.subscribe(LOCATION, ((topic, message) -> {
                JSONObject jsonObject = new JSONObject(new String(message.getPayload()));
                DbLocation dbLocation = DbLocation.builder()
                        .latitude(Double.parseDouble(jsonObject.get("latitude").toString()))
                        .longitude(Double.parseDouble(jsonObject.get("longitude").toString()))
                        .electronicCardId(Integer.parseInt(jsonObject.get("id").toString()))
                        .build();
                locationService.create(dbLocation);
                logger.info("--> Mqtt server send message for " + topic + "topic: " + message);
            }));
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
        super.listener();
    }
}
