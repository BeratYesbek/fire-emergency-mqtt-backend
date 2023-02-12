package com.bm.fire_emergency_mqtt_backend;

import com.bm.fire_emergency_mqtt_backend.dbConfiguration.ExecuteDbSchema;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Import(ExecuteDbSchema.class)

class FireEmergencyMqttBackendApplicationTests {



}
