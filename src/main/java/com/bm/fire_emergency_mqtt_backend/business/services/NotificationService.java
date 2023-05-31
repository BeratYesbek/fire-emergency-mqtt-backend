package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbNotification;

import java.util.List;

public interface NotificationService {

    DataResult<DbNotification> add(DbNotification dbNotification);

    DataResult<List<DbNotification>> findAllByUserId(int userId);

    DataResult<List<DbNotification>> findAllByCardId(int cardId);
}
