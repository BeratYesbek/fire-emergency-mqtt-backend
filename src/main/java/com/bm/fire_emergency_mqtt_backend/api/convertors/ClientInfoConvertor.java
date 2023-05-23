package com.bm.fire_emergency_mqtt_backend.api.convertors;

import com.bm.fire_emergency_mqtt_backend.api.dto.PageDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo.ClientInfoCreateDto;
import com.bm.fire_emergency_mqtt_backend.api.dto.clientInfo.ClientInfoReadDto;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public final class ClientInfoConvertor {

    private ClientInfoConvertor() {

    }

    public static DbClientInfo convertCreateRequestToDbClientInfo(ClientInfoCreateDto clientInfoDto) {
        DbClientInfo dbClientInfo = DbClientInfo.builder()
                .latitude(clientInfoDto.getLatitude())
                .longitude(clientInfoDto.getLongitude())
                .phoneBrand(clientInfoDto.getPhoneBrand())
                .token(clientInfoDto.getToken())
                .phoneName(clientInfoDto.getPhoneName())
                .operatingSystem(clientInfoDto.getOperatingSystem())
                .dbUser(
                        DbUser.builder().build()
                )
                .build();
        dbClientInfo.getDbUser().setId(clientInfoDto.getUserId());
        return dbClientInfo;
    }

    public static PageDto<ClientInfoReadDto> convertPageDbClientInfoToPageClientInfoReadDto(Page<DbClientInfo> clientInfo) {
        List<ClientInfoReadDto> clientInfoReadDtoList = new ArrayList<>();
        clientInfo.getContent().forEach(item -> clientInfoReadDtoList.add(convertDbClientInfoToClientInfoReadDto(item)));

        return PageDto.<ClientInfoReadDto>builder().page(clientInfo.getNumber())
                .size(clientInfo.getSize())
                .total(clientInfo.getTotalElements())
                .totalPage(clientInfo.getTotalPages())
                .content(clientInfoReadDtoList).build();
    }

    private static ClientInfoReadDto convertDbClientInfoToClientInfoReadDto(DbClientInfo dbClientInfo) {
        return ClientInfoReadDto.builder().latitude(dbClientInfo.getLatitude())
                .id(dbClientInfo.getId())
                .phoneUUID(dbClientInfo.getPhoneUUID())
                .createdAt(dbClientInfo.getCreatedAt())
                .latitude(dbClientInfo.getLatitude())
                .longitude(dbClientInfo.getLongitude())
                .phoneBrand(dbClientInfo.getPhoneBrand())
                .phoneName(dbClientInfo.getPhoneName())
                .operatingSystem(dbClientInfo.getOperatingSystem())
                .userReadDto(UserConvertor.convertDbUserToUserReadDto(dbClientInfo.getDbUser()))
                .build();
    }
}


