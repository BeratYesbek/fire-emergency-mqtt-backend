package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateRoleColumnConstants.COL_NAME;

public interface RoleDao extends JpaRepository<DbRole, Integer> {
    DbRole findByName(@Param(COL_NAME) String name);
}
