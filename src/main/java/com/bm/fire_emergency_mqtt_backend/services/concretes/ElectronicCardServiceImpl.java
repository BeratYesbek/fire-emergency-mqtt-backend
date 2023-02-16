package com.bm.fire_emergency_mqtt_backend.services.concretes;

import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ElectronicCardMessages;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessResult;
import com.bm.fire_emergency_mqtt_backend.dataAccess.abstracts.ElectronicCardDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCard;
import com.bm.fire_emergency_mqtt_backend.services.abstracts.ElectronicCardService;
import org.springframework.stereotype.Service;

@Service
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
    public DataResult<DbElectronicCard> update(DbElectronicCard entity, int id) throws Exception {
        return new SuccessDataResult<>(electronicCardDao.save(entity),ElectronicCardMessages.UPDATE_ELECTRONIC_CARD);
    }

    @Override
    public Result delete(int id) {
        electronicCardDao.deleteById(id);
        return new SuccessResult(ElectronicCardMessages.DELETE_ELECTRONIC_CARD);
    }
}
