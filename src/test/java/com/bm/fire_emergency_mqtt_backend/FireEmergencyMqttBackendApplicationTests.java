package com.bm.fire_emergency_mqtt_backend;

import com.bm.fire_emergency_mqtt_backend.business.validations.UserValidation;
import com.bm.fire_emergency_mqtt_backend.core.annotations.Validation;
import com.bm.fire_emergency_mqtt_backend.dbConfiguration.ExecuteDbSchema;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
@Import(ExecuteDbSchema.class)
class FireEmergencyMqttBackendApplicationTests {

    @Validation(validator = UserValidation.class)
    public void save(DbUser dbUser) {

    }

    @Test
    public void test() {
        save(DbUser.builder().email("Messai").build());
    }

}
