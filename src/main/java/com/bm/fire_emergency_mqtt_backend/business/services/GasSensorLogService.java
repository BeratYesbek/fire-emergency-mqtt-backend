package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbGasSensorLog;

public interface GasSensorLogService  {

    DataResult<DbGasSensorLog> create(DbGasSensorLog dbGasSensorLog);

}
