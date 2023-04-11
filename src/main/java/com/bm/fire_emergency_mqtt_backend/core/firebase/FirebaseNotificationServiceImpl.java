package com.bm.fire_emergency_mqtt_backend.core.firebase;

import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.stereotype.Service;

@Service
public class FirebaseNotificationServiceImpl implements FirebaseNotificationService {

    private final FirebaseMessaging firebaseMessaging;

    public FirebaseNotificationServiceImpl(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    @Override
    public void send(String message) {

    }
}
