package com.bm.fire_emergency_mqtt_backend.controllers;

import com.bm.fire_emergency_mqtt_backend.api.controllers.ElectronicCardUsersController;
import com.bm.fire_emergency_mqtt_backend.api.dto.PageDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.electronicCardUser.ElectronicCardUserCreateDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.electronicCardUser.ElectronicCardUserReadDto;
import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ElectronicCardUserMessage;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCardUser;
import com.bm.fire_emergency_mqtt_backend.services.ElectronicCardUserService;
import org.junit.jupiter.api.Assertions;
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
import java.util.List;

import static com.bm.fire_emergency_mqtt_backend.data.StaticDbEntitiesData.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ElectronicCardUsersControllerTest {

    private final static int userId = 5;
    @Mock
    private ElectronicCardUserService electronicCardUserService;
    @InjectMocks
    private ElectronicCardUsersController electronicCardUsersController;

    @Test
    public void testCreate() {
        when(electronicCardUserService.create(any())).thenReturn(prepareDataResultForElectronicCardUser());
        ResponseEntity<DataResult<ElectronicCardUserReadDto>> response =
                electronicCardUsersController.create(electronicCardUserCreateDto);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testFindAllByUserId() {
        when(electronicCardUserService.findByUserId(PageRequest.of(0,10),userId))
                .thenReturn(prepareDataResultListForElectronicCardUser());
        ResponseEntity<DataResult<PageDto<ElectronicCardUserReadDto>>> response =
                electronicCardUsersController.findAllByUserId(userId,0,10);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private static DataResult<Page<DbElectronicCardUser>> prepareDataResultListForElectronicCardUser() {
        dbElectronicCardUsers.add(electronicCardUser);
        dbElectronicCardUsers.add(electronicCardUser);
        dbElectronicCardUsers.add(electronicCardUser);
        Page<DbElectronicCardUser> dbElectronicCardUserPage =
                new PageImpl<>(dbElectronicCardUsers, PageRequest.of(0, 10), 10);
        return new SuccessDataResult<>(dbElectronicCardUserPage, "");
    }



    private static DataResult<DbElectronicCardUser> prepareDataResultForElectronicCardUser() {
        return new SuccessDataResult<>(electronicCardUser,
                ElectronicCardUserMessage.CREATE_ELECTRONIC_CARD_USER);
    }

    private static List<DbElectronicCardUser> dbElectronicCardUsers = new ArrayList<>();

    private static final ElectronicCardUserCreateDto electronicCardUserCreateDto = ElectronicCardUserCreateDto.builder()
            .name("Valinor")
            .user(dbUser)
            .build();


}
