package com.bm.fire_emergency_mqtt_backend.services.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import com.bm.fire_emergency_mqtt_backend.services.abstracts.common.BaseServiceRepository;

public interface UserService extends BaseServiceRepository<DbUser> {
}
