package com.bm.fire_emergency_mqtt_backend.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.GasSensorLogMessage;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.GasSensorLogDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbGasSensorLog;
import org.springframework.stereotype.Service;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.GasSensorLogMessage.*;

@Service
public class GasSensorLogServiceImpl implements GasSensorLogService {

    private final GasSensorLogDao gasSensorLogDao;

    public GasSensorLogServiceImpl(GasSensorLogDao gasSensorLogDao) {
        this.gasSensorLogDao = gasSensorLogDao;
    }

    @Override
    public DataResult<DbGasSensorLog> create(DbGasSensorLog dbGasSensorLog) {
        return new SuccessDataResult<>(gasSensorLogDao.save(dbGasSensorLog), CREATE_GAS_SENSOR_LOG);
    }



}
