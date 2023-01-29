package com.bm.fire_emergency_mqtt_backend.services.common;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;

public interface BaseServiceRepository<T> {

    DataResult<T> create(T entity);
    DataResult<T> update(T entity, int id) throws Exception;
    Result delete(int id);

}
