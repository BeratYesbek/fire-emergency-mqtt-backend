package com.bm.fire_emergency_mqtt_backend.core.notification;

import com.google.firebase.messaging.FirebaseMessagingException;

public interface NotificationService {
    void send(String message,String token) throws FirebaseMessagingException;
}
