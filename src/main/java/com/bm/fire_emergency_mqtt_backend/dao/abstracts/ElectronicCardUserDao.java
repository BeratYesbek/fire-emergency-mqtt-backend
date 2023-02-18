package com.bm.fire_emergency_mqtt_backend.dao.abstracts;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbElectronicCardUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectronicCardUserDao extends JpaRepository<DbElectronicCardUser, Integer> {

    Page<DbElectronicCardUser> findDbElectronicCardUserByDbUser(Pageable pageable, int userId);
}
