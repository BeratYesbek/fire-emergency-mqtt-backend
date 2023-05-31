package com.bm.fire_emergency_mqtt_backend.business.services;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ErrorDataResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessDataResult;
import com.bm.fire_emergency_mqtt_backend.dao.abstracts.RoleDao;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.UserRoleMessage.*;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService{

    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public DataResult<DbRole> findDefaultRole(final String defaultRole) {
        DbRole dbRole = roleDao.findByName(defaultRole);
        if(dbRole != null) {
            return new SuccessDataResult<>(dbRole, FIND_DEFAULT_ROLE);
        }
        return new ErrorDataResult<>(null, FIND_FAILURE_DEFAULT_ROLE);
    }
}
