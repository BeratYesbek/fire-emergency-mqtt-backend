package com.bm.fire_emergency_mqtt_backend.api.controllers;

import com.bm.fire_emergency_mqtt_backend.api.dto.PageDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo.ClientInfoCreateDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo.ClientInfoReadDto;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.services.ClientInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bm.fire_emergency_mqtt_backend.api.convertors.ClientInfoConvertor.convertCreateRequestToDbClientInfo;
import static com.bm.fire_emergency_mqtt_backend.api.convertors.ClientInfoConvertor.convertPageDbClientInfoToPageClientInfoReadDto;

@RestController
@RequestMapping("api/clientInfo")
public class ClientInfoController {

    private final ClientInfoService clientInfoService;

    public ClientInfoController(ClientInfoService clientInfoService) {
        this.clientInfoService = clientInfoService;
    }

    @PostMapping
    public ResponseEntity<DataResult<DbClientInfo>> create(@RequestBody ClientInfoCreateDto createClientInfoDto) {
        DataResult<DbClientInfo> addedDbClientInfoResult = clientInfoService
                .create(convertCreateRequestToDbClientInfo(createClientInfoDto));

        if (addedDbClientInfoResult.isSuccess()) {
            return new ResponseEntity<>(addedDbClientInfoResult, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(addedDbClientInfoResult, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable(name = "id") int id) {
        Result result = clientInfoService.delete(id);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public ResponseEntity<DataResult<PageDto<ClientInfoReadDto>>> findAll(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        DataResult<Page<DbClientInfo>> dbClientInfoPage = clientInfoService.findAll(PageRequest.of(page, pageSize));
        PageDto<ClientInfoReadDto> clientInfoReadDtoPageDto = convertPageDbClientInfoToPageClientInfoReadDto(dbClientInfoPage.getData());
        if (dbClientInfoPage.isSuccess())
            return new ResponseEntity<>(new SuccessDataResult<>(clientInfoReadDtoPageDto, dbClientInfoPage.getMessage()), HttpStatus.OK);

        return new ResponseEntity<>(new ErrorDataResult<>(clientInfoReadDtoPageDto, dbClientInfoPage.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
