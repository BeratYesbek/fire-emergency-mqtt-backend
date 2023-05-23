package com.bm.fire_emergency_mqtt_backend.core.firebase;

import com.bm.fire_emergency_mqtt_backend.core.notification.NotificationMessage;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;

@Service
public class FirebaseNotificationServiceImpl implements FirebaseNotificationService {


    @Override
    public void send(NotificationMessage message, String token) throws FirebaseMessagingException {
        Notification notification = Notification
                .builder()
                .setTitle(message.getTitle())
                .setBody(message.getMessage())
                .build();

        Message notify = Message
                .builder()
                .setToken(token)
                .setNotification(notification)
                .build();

        FirebaseMessaging.getInstance().send(notify);
    }
}
