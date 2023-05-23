package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbClientInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientInfoDao extends JpaRepository<DbClientInfo, Integer> {

    List<DbClientInfo> findByDbUserId(int userId);
}
