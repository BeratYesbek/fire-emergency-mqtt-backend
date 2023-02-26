package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCardUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ElectronicCardUserService {

    DataResult<DbElectronicCardUser> create(DbElectronicCardUser dbElectronicCardUser);

    DataResult<DbElectronicCardUser> update(DbElectronicCardUser dbElectronicCardUser, int id);

    Result delete(int id);

    DataResult<Page<DbElectronicCardUser>> findByUserId(Pageable pageable, int userId);
}
