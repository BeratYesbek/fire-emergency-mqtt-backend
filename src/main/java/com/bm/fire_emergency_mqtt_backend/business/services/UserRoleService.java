package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUserRole;

import javax.xml.crypto.Data;

public interface UserRoleService {
    DataResult<DbUserRole> createDefaultRole(DbUserRole dbUserRole);
}
