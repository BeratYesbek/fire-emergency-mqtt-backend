package com.bm.fire_emergency_mqtt_backend.core.notification;

import com.google.firebase.messaging.FirebaseMessagingException;

public interface NotificationService<T extends NotificationMessage> {
    void send(T message,String token) throws FirebaseMessagingException;
}
