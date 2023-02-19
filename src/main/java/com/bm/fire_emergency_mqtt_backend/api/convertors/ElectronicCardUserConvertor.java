package com.bm.fire_emergency_mqtt_backend.api.convertors;

import com.bm.fire_emergency_mqtt_backend.api.dto.PageDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.electronicCardUser.ElectronicCardUserCreateDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.electronicCardUser.ElectronicCardUserReadDto;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCardUser;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public final class ElectronicCardUserConvertor {

    private ElectronicCardUserConvertor() {

    }

    public static DbElectronicCardUser convertCreateDtoToDbElectronicCardUser(ElectronicCardUserCreateDto createDto) {
        return DbElectronicCardUser.builder()
                .dbUser(createDto.getUser())
                .name(createDto.getName()).build();
    }

    public static ElectronicCardUserReadDto convertDbElectronicCardUserToReadDto(DbElectronicCardUser electronicCardUser) {
        return ElectronicCardUserReadDto.builder()
                .id(electronicCardUser.getId())
                .name(electronicCardUser.getName())
                .uuid(electronicCardUser.getUuid())
                .user(UserConvertor.convertDbUserToUserReadDto(electronicCardUser.getDbUser()))
                .createdAt(electronicCardUser.getCreatedAt())
                .build();
    }

    public static PageDto<ElectronicCardUserReadDto> convertPageDbEntityToPageReadDto(Page<DbElectronicCardUser> dbElectronicCardUserPage) {
        List<ElectronicCardUserReadDto> dbElectronicCardUserList = new ArrayList<>();
        dbElectronicCardUserPage.getContent().forEach(item -> {
            dbElectronicCardUserList.add(convertDbElectronicCardUserToReadDto(item));
        });

        return PageDto.<ElectronicCardUserReadDto>builder().page(dbElectronicCardUserPage.getNumber())
                .size(dbElectronicCardUserPage.getSize())
                .total(dbElectronicCardUserPage.getTotalElements())
                .totalPage(dbElectronicCardUserPage.getTotalPages())
                .content(dbElectronicCardUserList).build();
    }
}
