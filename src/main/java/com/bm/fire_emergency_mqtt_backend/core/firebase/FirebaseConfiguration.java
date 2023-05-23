package com.bm.fire_emergency_mqtt_backend.core.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfiguration {
    @Bean
    FirebaseMessaging firebaseMessaging() {
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\berat\\IdeaProjects\\fire-emergency-mqtt-backend\\google_services.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(fileInputStream))
                    .build();
            FirebaseApp app = FirebaseApp.initializeApp(options);
            fileInputStream.close();
            return FirebaseMessaging.getInstance(app);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
