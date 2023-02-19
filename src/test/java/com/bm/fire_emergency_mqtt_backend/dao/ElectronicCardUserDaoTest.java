package com.bm.fire_emergency_mqtt_backend.dao;

import com.bm.fire_emergency_mqtt_backend.dao.abstracts.ElectronicCardUserDao;
import com.bm.fire_emergency_mqtt_backend.dbConfiguration.ExecuteDbSchema;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCardUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import static com.bm.fire_emergency_mqtt_backend.data.StaticDbEntitiesData.electronicCardUser;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@Import(ExecuteDbSchema.class)
public class ElectronicCardUserDaoTest {

    private final static int userId = 5;

    @Autowired
    private ElectronicCardUserDao electronicCardUserDao;

    @Test
    public void testSave() {
        electronicCardUser.getDbUser().setId(userId);
        DbElectronicCardUser dbElectronicCardUser = electronicCardUserDao.save(electronicCardUser);
        assertNotNull(dbElectronicCardUser);

    }
    @Test
    public void testFindAllByUserId() {
        assertNotNull(electronicCardUserDao.findAllByDbUserId(userId, PageRequest.of(0,10)));
    }

}
