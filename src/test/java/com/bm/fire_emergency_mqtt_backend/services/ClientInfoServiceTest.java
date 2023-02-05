package com.bm.fire_emergency_mqtt_backend.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.dataAccess.abstracts.ClientInfoDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ClientInfoServiceTest {

    @Mock
    private ClientInfoDao clientInfoDao;

    @InjectMocks
    private ClientInfoServiceImpl clientInfoService;

    @Test
    public void testCreate() {
        when(clientInfoDao.save(any())).thenReturn(clientInfo);
        DataResult<DbClientInfo> clientInfoDataResult = clientInfoService.create(any());
        assertTrue(clientInfoDataResult.isSuccess());

    }

    private static final DbClientInfo clientInfo = DbClientInfo.builder()
            .dbUser(null)
            .phoneName("BERAT Samsung Galaxy S21 FE")
            .phoneUUID("c939baa8-a578-11ed-b9df-0242ac120003")
            .phoneBrand("Samsung Galaxy S21 FE")
            .latitude(23.56455645)
            .longitude(43.6545464)
            .build();

}
