package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateUserColumnConstants.COL_EMAIL;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateUserColumnConstants.COL_USERNAME;

public interface UserDao extends JpaRepository<DbUser, Integer> {

    DbUser findByUsername(@Param(COL_USERNAME) String username);

    DbUser findByEmail(@Param(COL_EMAIL) String email);
}
