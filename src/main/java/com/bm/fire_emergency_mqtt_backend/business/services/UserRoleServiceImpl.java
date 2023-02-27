package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.UserRoleDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUserRole;
import org.springframework.stereotype.Service;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.UserRoleMessage.*;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleDao userRoleDao;

    public UserRoleServiceImpl(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }


    @Override
    public DataResult<DbUserRole> createDefaultRole(DbUserRole dbUserRole) {
        DbUserRole createdRole = userRoleDao.save(dbUserRole);
        if (createdRole != null)
            return new SuccessDataResult<>(createdRole, CREATE_DEFAULT_ROLE);
        return new ErrorDataResult<>(createdRole, CREATE_FAILURE_DEFAULT_ROLE);
    }
}
