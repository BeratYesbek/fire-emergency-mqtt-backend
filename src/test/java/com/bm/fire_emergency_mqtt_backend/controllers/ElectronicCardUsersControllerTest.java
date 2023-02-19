package com.bm.fire_emergency_mqtt_backend.controllers;

import com.bm.fire_emergency_mqtt_backend.api.controllers.ElectronicCardUsersController;
import com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo.ClientInfoCreateDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.electronicCardUser.ElectronicCardUserCreateDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.electronicCardUser.ElectronicCardUserReadDto;
import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ClientInfoMessages;
import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ElectronicCardUserMessage;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCardUser;
import com.bm.fire_emergency_mqtt_backend.services.ElectronicCardUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.bm.fire_emergency_mqtt_backend.data.StaticDbEntitiesData.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ElectronicCardUsersControllerTest {

    @Mock
    private ElectronicCardUserService electronicCardUserService;
    @InjectMocks
    private ElectronicCardUsersController electronicCardUsersController;

    @Test
    public void testCreate() {
        when(electronicCardUserService.create(any())).thenReturn(prepareDataResultForElectronicCardUser());
        ResponseEntity<DataResult<ElectronicCardUserReadDto>> response =
                electronicCardUsersController.create(electronicCardUserCreateDto);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }



    private static DataResult<DbElectronicCardUser> prepareDataResultForElectronicCardUser() {
        return new SuccessDataResult<>(electronicCardUser,
                ElectronicCardUserMessage.CREATE_ELECTRONIC_CARD_USER);
    }


    private static final ElectronicCardUserCreateDto electronicCardUserCreateDto = ElectronicCardUserCreateDto.builder()
            .name("Valinor")
            .user(dbUser)
            .build();


}
