package com.bm.fire_emergency_mqtt_backend.dataAccess.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDao extends JpaRepository<DbLocation,Integer> {
}
