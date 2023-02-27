package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateUserRoleColumnConstants.COL_USER_ID;

public interface UserRoleDao extends JpaRepository<DbUserRole, Integer> {
    List<DbUserRole> findAllByDbUserId(@Param(COL_USER_ID) int userId);
}
