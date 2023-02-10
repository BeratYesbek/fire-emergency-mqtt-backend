package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientInfoDao extends JpaRepository<DbClientInfo, Integer> {
}
