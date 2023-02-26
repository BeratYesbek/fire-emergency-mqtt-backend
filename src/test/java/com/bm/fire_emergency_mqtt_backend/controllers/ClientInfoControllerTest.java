package com.bm.fire_emergency_mqtt_backend.controllers;

import com.bm.fire_emergency_mqtt_backend.api.controllers.ClientInfoController;
import com.bm.fire_emergency_mqtt_backend.api.dto.PageDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo.ClientInfoCreateDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo.ClientInfoReadDto;
import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ClientInfoMessages;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.business.services.ClientInfoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Objects;
import java.util.List;

import static com.bm.fire_emergency_mqtt_backend.data.StaticDbEntitiesData.clientInfo;
import static com.bm.fire_emergency_mqtt_backend.data.StaticDbEntitiesData.dbUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClientInfoControllerTest {

    @Mock
    private ClientInfoService clientInfoService;
    @InjectMocks
    private ClientInfoController clientInfoController;

    @Test
    public void testCreate() {
        when(clientInfoService.create(any())).thenReturn(prepareDataResultForClientInfo());
        ResponseEntity<DataResult<DbClientInfo>> response = clientInfoController.create(createClientInfoDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testDelete() {
        when(clientInfoService.delete(ID)).thenReturn(prepareSuccessResultForDelete());
        ResponseEntity<Result> response = clientInfoController.delete(ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(Objects.requireNonNull(response.getBody()).isSuccess());
    }

    @Test
    public void testFindAll() {
        when(clientInfoService.findAll(any())).thenReturn(prepareDataResultListForClientInfo());
        ResponseEntity<DataResult<PageDto<ClientInfoReadDto>>> response = clientInfoController.findAll(1, 10);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    private static DataResult<Page<DbClientInfo>> prepareDataResultListForClientInfo() {
        dbClientInfoList.add(clientInfo);
        dbClientInfoList.add(clientInfo);
        dbClientInfoList.add(clientInfo);
        Page<DbClientInfo> dbClientInfoPage =
                new PageImpl<DbClientInfo>(dbClientInfoList, PageRequest.of(0, 10), 10);
        return new SuccessDataResult<>(dbClientInfoPage, "");
    }

    private static DataResult<DbClientInfo> prepareDataResultForClientInfo() {
        return new SuccessDataResult<>(clientInfo, ClientInfoMessages.CREATE_CLIENT_INFO);
    }

    private static Result prepareSuccessResultForDelete() {
        return new SuccessResult(ClientInfoMessages.DELETE_CLIENT_INFO);
    }

    private int ID = 1;


    private static List<DbClientInfo> dbClientInfoList = new ArrayList<>();

    private static ClientInfoCreateDto createClientInfoDto = ClientInfoCreateDto.builder()
            .dbUser(dbUser)
            .phoneName("BERAT Samsung Galaxy S21 FE")
            .phoneUUID("c939baa8-a578-11ed-b9df-0242ac120003")
            .phoneBrand("Samsung Galaxy S21 FE")
            .latitude(23.56455645)
            .longitude(43.6545464)
            .build();

}
