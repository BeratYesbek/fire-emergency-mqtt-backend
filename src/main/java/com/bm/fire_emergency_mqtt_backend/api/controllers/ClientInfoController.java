package com.bm.fire_emergency_mqtt_backend.api.controllers;

import com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo.CreateClientInfoDto;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.services.ClientInfoService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/clientInfo")
public class ClientInfoController {

    private final ClientInfoService clientInfoService;
    private final ModelMapper modelMapper;

    public ClientInfoController(ClientInfoService clientInfoService, ModelMapper modelMapper) {
        this.clientInfoService = clientInfoService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<DataResult<DbClientInfo>> create(@RequestBody CreateClientInfoDto createClientInfoDto) {
        DbClientInfo dbClientInfo = modelMapper.map(createClientInfoDto, DbClientInfo.class);
        DataResult<DbClientInfo> addedDbClientInfoResult = clientInfoService.create(dbClientInfo);
        if (addedDbClientInfoResult.isSuccess()) {
            return new ResponseEntity<>(addedDbClientInfoResult, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(addedDbClientInfoResult, HttpStatus.BAD_REQUEST);
    }
}
