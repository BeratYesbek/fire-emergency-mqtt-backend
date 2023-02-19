package com.bm.fire_emergency_mqtt_backend.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbLocation;

public interface LocationService {

    DataResult<DbLocation> create(DbLocation entity);

    DataResult<DbLocation> update(DbLocation entity, int id);

    Result delete(int id);

}
