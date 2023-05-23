package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.ElectronicCardUserDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCardUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ElectronicCardMessages.GET_ELECTRONIC_CARD;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.ElectronicCardUserMessage.*;

@Service
@Transactional
public class ElectronicCardUserServiceImpl implements ElectronicCardUserService {

    private final ElectronicCardUserDao electronicCardUserDao;

    public ElectronicCardUserServiceImpl(ElectronicCardUserDao electronicCardUserDao) {
        this.electronicCardUserDao = electronicCardUserDao;
    }

    @Override
    public DataResult<DbElectronicCardUser> create(DbElectronicCardUser dbElectronicCardUser) {
        DbElectronicCardUser addedEntity = electronicCardUserDao.save(dbElectronicCardUser);
        return new SuccessDataResult<>(addedEntity, CREATE_ELECTRONIC_CARD_USER);
    }

    @Override
    public DataResult<DbElectronicCardUser> update(DbElectronicCardUser dbElectronicCardUser, int id) {
        return null;
    }

    @Override
    public DataResult<DbElectronicCardUser> findByCardId(int id) {
        return new SuccessDataResult<>(electronicCardUserDao.findByDbElectronicCardId(id), GET_ELECTRONIC_CARD);
    }

    @Override
    public Result delete(int id) {
        electronicCardUserDao.deleteById(id);
        return new SuccessResult(DELETE_ELECTRONIC_CARD_USER);
    }

    @Override
    public DataResult<Page<DbElectronicCardUser>> findByUserId(Pageable pageable, int userId) {
        Page<DbElectronicCardUser> dbElectronicCardUsers = electronicCardUserDao.findAllByDbUserId(userId, pageable);
        return new SuccessDataResult<>(dbElectronicCardUsers, LIST_ELECTRONIC_CARD_USER);
    }
}
