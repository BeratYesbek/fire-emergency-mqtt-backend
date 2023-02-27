package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.security.roles.Role;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.UserRoleDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbRole;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUserRole;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.UserRoleMessage.*;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleDao userRoleDao;
    private final RoleService roleService;

    public UserRoleServiceImpl(UserRoleDao userRoleDao, RoleService roleService) {
        this.userRoleDao = userRoleDao;
        this.roleService = roleService;
    }


    @Override
    public DataResult<DbUserRole> createDefaultRole(DbUserRole dbUserRole) {
        DataResult<DbRole> dbRoleDataResult = roleService.findDefaultRole(Role.USER.name());
        if (!dbRoleDataResult.isSuccess()) {
            return new ErrorDataResult<>(null, dbRoleDataResult.getMessage());
        }
        dbUserRole.setDbRole(dbRoleDataResult.getData());
        DbUserRole createdRole = userRoleDao.save(dbUserRole);
        return new SuccessDataResult<>(createdRole, CREATE_DEFAULT_ROLE);
    }

    @Override
    public DataResult<List<DbUserRole>> findUserRoleByUserId(final int userId) {
        List<DbUserRole> dbUserRoleList = userRoleDao.findAllByDbUserId(userId);
        return new SuccessDataResult<>(dbUserRoleList, FIND_ALL_USER_ROLE);
    }
}
