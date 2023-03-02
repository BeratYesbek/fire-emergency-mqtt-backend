package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateRoleColumnConstants;
import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateRoleColumnConstants.COL_NAME;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.ROLE_TABLE;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = ROLE_TABLE)
public class DbRole extends DbEntity {

    @Column(name = COL_NAME)
    private String name;

    @Override
    public String toString() {
        return "DbRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                '}';
    }
}
