package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.UserDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<DbUser> create(DbUser dbUser) {
        // TODO validation for  db userData
        return null;
    }

    @Override
    public DataResult<DbUser> findByUsername(String username) {
        return null;
    }

    @Override
    public DataResult<DbUser> findByEmail(String email) {
        return null;
    }
}
