package com.bm.fire_emergency_mqtt_backend.mqtt.listeners;

import com.bm.fire_emergency_mqtt_backend.business.services.ClientInfoService;
import com.bm.fire_emergency_mqtt_backend.business.services.ElectronicCardService;
import com.bm.fire_emergency_mqtt_backend.business.services.NotificationService;
import com.bm.fire_emergency_mqtt_backend.core.annotations.MqttListener;
import com.bm.fire_emergency_mqtt_backend.core.firebase.FirebaseMessage;
import com.bm.fire_emergency_mqtt_backend.core.firebase.FirebaseNotificationService;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCard;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbNotification;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;

import com.google.firebase.messaging.FirebaseMessagingException;
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
    private final NotificationService notifyService;


    public MqttUrgentListener(IMqttClient mqttClient, ElectronicCardService electronicCardService, FirebaseNotificationService notificationService, ClientInfoService clientInfoService, NotificationService notifyService) {
        super(mqttClient);
        this.mqttClient = mqttClient;
        this.electronicCardService = electronicCardService;
        this.notificationService = notificationService;
        this.clientInfoService = clientInfoService;
        this.notifyService = notifyService;
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
                System.out.println(electronicCard.toString());
                if (electronicCard != null) {
                    String token = getToken(electronicCard);
                    sendNotification(electronicCard.getDbElectronicCardUser().getName(), electronicCard.getElectronicCardUUID(), token, urgentLevel);
                    addNotification(electronicCard.getDbElectronicCardUser().getDbUser(),
                            electronicCard,
                            electronicCard.getDbElectronicCardUser().getName(),
                            urgentLevel
                    );
                }
            }));
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
        super.listener();
    }

    private String getToken(final DbElectronicCard dbElectronicCard) {
        DbUser dbUser = dbElectronicCard.getDbElectronicCardUser().getDbUser();
        DbClientInfo dbClientInfo = clientInfoService.findByUserId(dbUser.getId()).getData();
        return dbClientInfo.getToken();
    }

    private void addNotification(DbUser dbUser, DbElectronicCard dbElectronicCard, String cardName, String urgentLevel) {
        String notificationMessage = String.format("Urgent!! from your this card: %s, Potential dangerous level is %s cardId: %s",
                cardName, urgentLevel, dbElectronicCard.getElectronicCardUUID());
        String title = "Urgent!!! " + urgentLevel;
        notifyService.add(
                DbNotification.builder()
                        .dbUser(dbUser)
                        .dbElectronicCard(dbElectronicCard)
                        .title(title)
                        .message(notificationMessage)
                        .build()
        );
    }

    private void sendNotification(String cardName, String cardId, String token, String urgentLevel) throws FirebaseMessagingException {
        String notificationMessage = String.format("Urgent!! from your this card: %s, Potential dangerous level is %s cardId: %s",
                cardName, urgentLevel, cardId);
        notificationService.send(
                FirebaseMessage.builder().message(notificationMessage)
                        .title("Urgent!!! " + urgentLevel).build(),
                token
        );
    }

}
