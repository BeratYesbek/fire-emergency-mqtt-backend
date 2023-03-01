package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ElectronicCardMessages;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.ElectronicCardDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCard;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ElectronicCardServiceImpl implements ElectronicCardService {

    private final ElectronicCardDao electronicCardDao;

    public ElectronicCardServiceImpl(ElectronicCardDao electronicCardDao) {
        this.electronicCardDao = electronicCardDao;
    }

    @Override
    public DataResult<DbElectronicCard> create(DbElectronicCard entity) {
        return new SuccessDataResult<>(electronicCardDao.save(entity), ElectronicCardMessages.UPDATE_ELECTRONIC_CARD);
    }

    @Override
    public DataResult<DbElectronicCard> update(DbElectronicCard entity, int id)  {
        return new SuccessDataResult<>(electronicCardDao.save(entity),ElectronicCardMessages.UPDATE_ELECTRONIC_CARD);
    }

    @Override
    public Result delete(int id) {
        electronicCardDao.deleteById(id);
        return new SuccessResult(ElectronicCardMessages.DELETE_ELECTRONIC_CARD);
    }
}
