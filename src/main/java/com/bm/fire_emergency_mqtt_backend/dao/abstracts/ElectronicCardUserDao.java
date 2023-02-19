package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCardUser;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ElectronicCardUserDao extends JpaRepository<DbElectronicCardUser, Integer> {

    Page<DbElectronicCardUser> findAllByDbUserId(int userId, Pageable pageable);
}
