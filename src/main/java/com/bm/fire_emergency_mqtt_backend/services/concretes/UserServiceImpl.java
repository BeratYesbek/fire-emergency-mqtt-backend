package com.bm.fire_emergency_mqtt_backend.services.concretes;

import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.UserMessages;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessResult;
import com.bm.fire_emergency_mqtt_backend.dataAccess.abstracts.UserDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import com.bm.fire_emergency_mqtt_backend.services.abstracts.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<DbUser> create(DbUser entity) {
        return new SuccessDataResult<>(userDao.save(entity), UserMessages.CREATE_USER);
    }

    @Override
    public DataResult<DbUser> update(DbUser entity, int id) throws Exception {
        return new SuccessDataResult<>(userDao.save(entity),UserMessages.UPDATE_USER);
    }

    @Override
    public Result delete(int id) {
        userDao.deleteById(id);
        return new SuccessResult(UserMessages.DELETE_USER);
    }
}
