package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<DbUser, Integer> {
}
