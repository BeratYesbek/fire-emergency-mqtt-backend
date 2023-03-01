package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.UserDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.UserMessages.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<DbUser> create(DbUser dbUser) {
        return new SuccessDataResult<>(userDao.save(dbUser), CREATE_USER);
    }

    @Override
    public DataResult<DbUser> findByUsername(final String username) {
        DbUser dbUser = userDao.findByUsername(username);
        if (dbUser != null)
            return new SuccessDataResult<>(dbUser, USER_FOUND);

        return new ErrorDataResult<>(null, USER_NOT_FOUND);
    }

    @Override
    public DataResult<DbUser> findByEmail(String email) {
        DbUser dbUser = userDao.findByEmail(email);
        if (dbUser != null)
            return new SuccessDataResult<>(dbUser, USER_FOUND);

        return new ErrorDataResult<>(null, USER_NOT_FOUND);
    }
}
