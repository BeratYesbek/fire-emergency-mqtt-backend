package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.USER_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateUserColumnConstants.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = USER_TABLE)
public class DbUser extends DbEntity {

    @Column(name = COL_EMAIL, nullable = false)
    private String email;

    @Column(name = COL_USERNAME, nullable = false)
    private String username;

    @Column(name = COL_FULL_NAME, nullable = false)
    private String fullName;

    @Column(name = COL_PASSWORD, nullable = false)
    private String password;


}
