package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.GasSensorLogDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbGasSensorLog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.GasSensorLogMessage.*;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
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
