package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateRoleColumnConstants;
import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateRoleColumnConstants.COL_NAME;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.ROLE_TABLE;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ROLE_TABLE)
public class DbRole extends DbEntity {

    @Column(name = COL_NAME)
    private String name;
}
