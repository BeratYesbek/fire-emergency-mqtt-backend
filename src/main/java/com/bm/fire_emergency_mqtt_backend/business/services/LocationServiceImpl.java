package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.LocationMessages;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.LocationDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbLocation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    private final LocationDao locationDao;

    public LocationServiceImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public DataResult<DbLocation> create(DbLocation entity) {
        return new SuccessDataResult<>(locationDao.save(entity), LocationMessages.CREATE_LOCATION);
    }

}
