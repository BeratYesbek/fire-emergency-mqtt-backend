package com.bm.fire_emergency_mqtt_backend.dao;

import com.bm.fire_emergency_mqtt_backend.dao.abstracts.ClientInfoDao;

import com.bm.fire_emergency_mqtt_backend.dbConfiguration.*;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import static com.bm.fire_emergency_mqtt_backend.data.StaticDbEntitiesData.clientInfo;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@Import(ExecuteDbSchema.class)
public class ClientInfoDaoTest {

    public static final int ID = 25;

    @Autowired
    private ClientInfoDao clientInfoDao;

    @Test
    public void testSave() {
        clientInfo.getDbUser().setId(5);
        DbClientInfo dbClientInfo = clientInfoDao.save(clientInfo);
        assertNotNull(dbClientInfo);
    }

    @Test
    public void testDeleteById() {
        clientInfo.setId(ID);
        clientInfoDao.deleteById(ID);
    }

    @Test
    public void testFindAll() {
       assertNotNull(clientInfoDao.findAll());
    }
}
