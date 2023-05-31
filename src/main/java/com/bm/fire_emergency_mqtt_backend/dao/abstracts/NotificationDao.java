package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbNotification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationDao extends JpaRepository<DbNotification, Integer> {
    List<DbNotification> findAllByDbUserId(int userId);

    List<DbNotification> findAllByDbElectronicCardId(int cardId);
}
