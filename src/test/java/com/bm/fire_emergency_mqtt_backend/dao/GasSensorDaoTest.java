package com.bm.fire_emergency_mqtt_backend.dao;

import com.bm.fire_emergency_mqtt_backend.dao.abstracts.GasSensorLogDao;
import com.bm.fire_emergency_mqtt_backend.dbConfiguration.ExecuteDbSchema;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbGasSensorLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static com.bm.fire_emergency_mqtt_backend.data.StaticDbEntitiesData.gasSensorLog;
import static org.junit.Assert.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@Import(ExecuteDbSchema.class)
public class GasSensorDaoTest {

    @Autowired
    private GasSensorLogDao gasSensorLogDao;

    @Test
    public void testSave() {
        DbGasSensorLog dbGasSensorLog = gasSensorLogDao.save(gasSensorLog);
        assertNotNull(dbGasSensorLog);
    }

}
