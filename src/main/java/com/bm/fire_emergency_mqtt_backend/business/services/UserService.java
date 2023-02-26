package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;

public interface UserService {

    DataResult<DbUser> create(DbUser dbUser);
    DataResult<DbUser> findByUsername(String username);
    DataResult<DbUser> findByEmail(String email);
}
