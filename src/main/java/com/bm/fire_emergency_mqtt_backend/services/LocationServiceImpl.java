package com.bm.fire_emergency_mqtt_backend.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.LocationMessages;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.LocationDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbLocation;
import com.bm.fire_emergency_mqtt_backend.services.LocationService;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationDao locationDao;

    public LocationServiceImpl(LocationDao locationDao) {
        this.locationDao = locationDao;
    }

    @Override
    public DataResult<DbLocation> create(DbLocation entity) {
        return new SuccessDataResult<>(locationDao.save(entity), LocationMessages.CREATE_LOCATION);
    }

    @Override
    public DataResult<DbLocation> update(DbLocation entity, int id)  {
        return new SuccessDataResult<>(locationDao.save(entity),LocationMessages.UPDATE_LOCATION);
    }

    @Override
    public Result delete(int id) {
        locationDao.deleteById(id);
        return new SuccessResult(LocationMessages.DELETE_LOCATION);
    }
}
