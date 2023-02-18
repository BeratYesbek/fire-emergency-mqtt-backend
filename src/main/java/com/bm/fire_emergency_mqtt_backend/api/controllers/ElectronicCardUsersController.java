package com.bm.fire_emergency_mqtt_backend.api.controllers;

import com.bm.fire_emergency_mqtt_backend.api.dto.PageDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.electronicCardUser.ElectronicCardUserCreateDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.electronicCardUser.ElectronicCardUserReadDto;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCardUser;
import com.bm.fire_emergency_mqtt_backend.services.ElectronicCardUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.bm.fire_emergency_mqtt_backend.api.convertors.ElectronicCardUserConvertor.*;

@RestController
@RequestMapping("api/electronicCardUsers")
public class ElectronicCardUsersController {

    private final ElectronicCardUserService electronicCardUserService;

    public ElectronicCardUsersController(ElectronicCardUserService electronicCardUserService) {
        this.electronicCardUserService = electronicCardUserService;
    }

    @PostMapping
    public ResponseEntity<DataResult<ElectronicCardUserReadDto>> create
            (@RequestBody ElectronicCardUserCreateDto userCreateDto) {
        DbElectronicCardUser dbElectronicCardUser = convertCreateDtoToDbElectronicCardUser(userCreateDto);
        DataResult<DbElectronicCardUser> result = electronicCardUserService.create(dbElectronicCardUser);
        if (result.isSuccess())
            return new ResponseEntity<>(new SuccessDataResult<>(convertDbElectronicCardUserToReadDto(result.getData()),
                    result.getMessage()), HttpStatus.CREATED);

        return new ResponseEntity<>(new ErrorDataResult<>(null, result.getMessage()), HttpStatus.BAD_REQUEST);

    }

    @GetMapping
    public ResponseEntity<DataResult<PageDto<ElectronicCardUserReadDto>>> findAllByUserId
            (@RequestParam("userId") int userId, @RequestParam("page") int page, @RequestParam("pageSize") int pageSize) {
        DataResult<Page<DbElectronicCardUser>> pageDataResult =
                electronicCardUserService.findByUserId(PageRequest.of(page, pageSize), userId);
        if (pageDataResult.isSuccess()) {
            PageDto<ElectronicCardUserReadDto> electronicCardUserReadDtoPageDto =
                    convertPageDbEntityToPageReadDto(pageDataResult.getData());
            return new ResponseEntity<>(new SuccessDataResult<>(electronicCardUserReadDtoPageDto, pageDataResult.getMessage()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new SuccessDataResult<>(null, pageDataResult.getMessage()), HttpStatus.BAD_REQUEST);

    }
}
