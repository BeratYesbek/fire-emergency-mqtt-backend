package com.bm.fire_emergency_mqtt_backend.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.dbConfiguration.ExecuteDbSchema;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbGasSensorLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static com.bm.fire_emergency_mqtt_backend.data.StaticDbEntitiesData.gasSensorLog;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@Import(ExecuteDbSchema.class)
public class GasSensorServiceTest {

    @Autowired
    private GasSensorLogServiceImpl gasSensorLogService;


    @Test
    public void testCreate() {
        DataResult<DbGasSensorLog> gasSensorLogDataResult
                = gasSensorLogService.create(gasSensorLog);
        assertTrue(gasSensorLogDataResult.isSuccess());
    }






}
