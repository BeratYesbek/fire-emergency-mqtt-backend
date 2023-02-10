package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbGasSensorLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GasSensorLogDao extends JpaRepository<DbGasSensorLog, Integer> {
}
