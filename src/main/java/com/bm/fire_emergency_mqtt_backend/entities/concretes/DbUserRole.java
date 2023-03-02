package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateCommonColumnConstants.COL_ID;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.USER_ROLE_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateUserRoleColumnConstants.COL_ROLE_ID;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateUserRoleColumnConstants.COL_USER_ID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = USER_ROLE_TABLE)
public class DbUserRole extends DbEntity {

    @ManyToOne
    @JoinColumn(name = COL_USER_ID, referencedColumnName = COL_ID, nullable = false)
    private DbUser dbUser;

    @ManyToOne
    @JoinColumn(name = COL_ROLE_ID, referencedColumnName = COL_ID, nullable = false)
    private DbRole dbRole;

    @Override
    public String toString() {
        return "DbUserRole{" +
                "id=" + id +
                ", dbUser=" + dbUser +
                ", dbRole=" + dbRole +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                '}';
    }
}
