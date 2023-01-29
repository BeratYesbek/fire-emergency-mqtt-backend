package com.bm.fire_emergency_mqtt_backend.services.common;

public interface BaseServiceRepository<T> {

    T create(T entity);
    T update(T entity, int id);
    void delete(int id);

}
