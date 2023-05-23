package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCard;

public interface ElectronicCardService {
    DataResult<DbElectronicCard> create(DbElectronicCard entity);

    DataResult<DbElectronicCard> update(DbElectronicCard entity, int id);

    DataResult<DbElectronicCard> findByCardUUID(String cardUUID);

    Result delete(int id);
}
