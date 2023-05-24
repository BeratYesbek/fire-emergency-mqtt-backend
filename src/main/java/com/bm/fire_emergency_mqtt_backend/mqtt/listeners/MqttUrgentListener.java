package com.bm.fire_emergency_mqtt_backend.mqtt.listeners;

import com.bm.fire_emergency_mqtt_backend.business.services.ClientInfoService;
import com.bm.fire_emergency_mqtt_backend.business.services.ElectronicCardService;
import com.bm.fire_emergency_mqtt_backend.core.annotations.MqttListener;
import com.bm.fire_emergency_mqtt_backend.core.firebase.FirebaseMessage;
import com.bm.fire_emergency_mqtt_backend.core.firebase.FirebaseNotificationService;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCard;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.concurrent.CompletableFuture;

import static com.bm.fire_emergency_mqtt_backend.mqtt.constants.MqttConstants.URGENT;

@MqttListener(name = "UrgentListener")
public class MqttUrgentListener extends AbstractMqttListener {

    private final IMqttClient mqttClient;
    private final ElectronicCardService electronicCardService;
    private final FirebaseNotificationService notificationService;
    private final ClientInfoService clientInfoService;

    public MqttUrgentListener(IMqttClient mqttClient, ElectronicCardService electronicCardService, FirebaseNotificationService notificationService, ClientInfoService clientInfoService) {
        super(mqttClient);
        this.mqttClient = mqttClient;
        this.electronicCardService = electronicCardService;
        this.notificationService = notificationService;
        this.clientInfoService = clientInfoService;
        CompletableFuture.runAsync(this::listener);
    }

    @Override
    protected void listener() {
        try {
            mqttClient.subscribe(URGENT, ((topic, message) -> {
                JSONObject jsonObject = new JSONObject(new String(message.getPayload()));
                String cardUUID = jsonObject.get("cardUUID").toString();
                String urgentLevel = jsonObject.get("urgentLevel").toString();
                DbElectronicCard electronicCard = electronicCardService.findByCardUUID(cardUUID).getData();
                if (electronicCard != null) {

                    // TODO optimization using lazy loading
                    DbUser dbUser = electronicCard.getDbElectronicCardUser().getDbUser();
                    DbClientInfo dbClientInfo = clientInfoService.findByUserId(dbUser.getId()).getData();
                    String token = dbClientInfo.getToken();
                    String notificationMessage = String.format("Urgent!! from your this card: %s, Potential dangerous level is %s ",
                            electronicCard.getDbElectronicCardUser().getName(), urgentLevel);
                    notificationService.send(
                            FirebaseMessage.builder().message(notificationMessage)
                                    .title("Urgent!!! " + urgentLevel).build(),
                            token
                    );
                }
            }));
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
        super.listener();
    }


}
