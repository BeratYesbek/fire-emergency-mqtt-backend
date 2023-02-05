package com.bm.fire_emergency_mqtt_backend.controllers;

import com.bm.fire_emergency_mqtt_backend.api.controllers.ClientInfoController;
import com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo.CreateClientInfoDto;
import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ClientInfoMessages;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.services.ClientInfoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class ClientInfoControllerTest {

    @Mock
    private ClientInfoService clientInfoService;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();
    @InjectMocks
    private ClientInfoController clientInfoController;

    @Test
    public void testCreate() {
        when(clientInfoService.create(clientInfo)).thenReturn(prepareDataResultForClientInfo());
        when(modelMapper.map(createClientInfoDto, DbClientInfo.class)).thenReturn(clientInfo);
        ResponseEntity<DataResult<DbClientInfo>> response = clientInfoController.create(createClientInfoDto);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    public static DataResult<DbClientInfo> prepareDataResultForClientInfo() {
        return new SuccessDataResult<>(clientInfo, ClientInfoMessages.CREATE_CLIENT_INFO);
    }

    private static DbClientInfo clientInfo = DbClientInfo.builder()
            .dbUser(null)
            .phoneName("BERAT Samsung Galaxy S21 FE")
            .phoneUUID("c939baa8-a578-11ed-b9df-0242ac120003")
            .phoneBrand("Samsung Galaxy S21 FE")
            .latitude(23.56455645)
            .longitude(43.6545464)
            .build();

    private static CreateClientInfoDto createClientInfoDto = CreateClientInfoDto.builder()
            .dbUser(null)
            .phoneName("BERAT Samsung Galaxy S21 FE")
            .phoneUUID("c939baa8-a578-11ed-b9df-0242ac120003")
            .phoneBrand("Samsung Galaxy S21 FE")
            .latitude(23.56455645)
            .longitude(43.6545464)
            .build();

}
