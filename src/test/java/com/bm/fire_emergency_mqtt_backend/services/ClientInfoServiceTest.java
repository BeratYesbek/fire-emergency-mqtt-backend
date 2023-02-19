package com.bm.fire_emergency_mqtt_backend.services;

import com.bm.fire_emergency_mqtt_backend.dbConfiguration.ExecuteDbSchema;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.UserDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import static com.bm.fire_emergency_mqtt_backend.data.StaticDbEntitiesData.clientInfo;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@Import(ExecuteDbSchema.class)
public class ClientInfoServiceTest {

    public static final int ID = 26;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ClientInfoServiceImpl clientInfoService;

    @Test
    public void testCreate() {
        clientInfo.getDbUser().setId(userDao.findAll().get(0).getId());
        DataResult<DbClientInfo> clientInfoDataResult = clientInfoService.create(clientInfo);
        assertTrue(clientInfoDataResult.isSuccess());
    }

    @Test
    public void testDelete() {
        Result result = clientInfoService.delete(ID);
        assertTrue(result.isSuccess());
    }

    @Test
    public void testFindAll() {
        DataResult<Page<DbClientInfo>> clientInfoDataResult = clientInfoService.findAll(PageRequest.of(0, 10));
        assertTrue(clientInfoDataResult.isSuccess());
    }
}
