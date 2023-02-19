package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ElectronicCardDao extends JpaRepository<DbElectronicCard,Integer> {
}
