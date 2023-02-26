package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.ElectronicCardUserDao;
import com.bm.fire_emergency_mqtt_backend.dbConfiguration.ExecuteDbSchema;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCardUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import static com.bm.fire_emergency_mqtt_backend.data.StaticDbEntitiesData.electronicCardUser;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
@Import(ExecuteDbSchema.class)
public class ElectronicCardUserServiceTest {

    private final static int userId = 5;
    @Autowired
    private ElectronicCardUserDao electronicCardUserDao;

    @Autowired
    private ElectronicCardUserServiceImpl electronicCardUserService;

    @Test
    public void testCreate() {
        electronicCardUser.getDbUser().setId(userId);
        DataResult<DbElectronicCardUser> dbElectronicCardUserDataResult = electronicCardUserService.create(electronicCardUser);
        assertTrue(dbElectronicCardUserDataResult.isSuccess());
    }

    @Test
    public void testFindAllByUserId() {
        DataResult<Page<DbElectronicCardUser>> pageDataResult =
                electronicCardUserService.findByUserId(PageRequest.of(0, 10), userId);
        assertTrue(pageDataResult.isSuccess());


    }
}
