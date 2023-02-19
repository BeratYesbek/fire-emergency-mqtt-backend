package com.bm.fire_emergency_mqtt_backend.api.controllers;

import com.bm.fire_emergency_mqtt_backend.api.dto.gasSensorLog.CreateGasSensorLogDto;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbGasSensorLog;
import com.bm.fire_emergency_mqtt_backend.services.GasSensorLogService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/gasSensorLog")
public class GasSensorLogsController {

    private final GasSensorLogService gasSensorLogService;
    private final ModelMapper modelMapper;

    public GasSensorLogsController(GasSensorLogService gasSensorLogService, ModelMapper modelMapper) {
        this.gasSensorLogService = gasSensorLogService;
        this.modelMapper = modelMapper;
    }

    public ResponseEntity<DataResult<DbGasSensorLog>> create(CreateGasSensorLogDto createGasSensorLogDto) {
        DbGasSensorLog dbGasSensorLog = modelMapper.map(createGasSensorLogDto, DbGasSensorLog.class);
        DataResult<DbGasSensorLog> result = gasSensorLogService.create(dbGasSensorLog);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
}
