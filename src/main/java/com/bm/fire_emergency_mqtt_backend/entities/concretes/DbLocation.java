package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.LOCATION_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateLocationColumnConstants.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = LOCATION_TABLE)
public class DbLocation extends DbEntity {

    @Column(name = COl_LATITUDE,nullable = false)
    private long latitude;

    @Column(name = COl_LONGITUDE,nullable = false)
    private long longitude;

//    @Column(name = COL_ELECTRONIC_CARD_ID,nullable = false)
//    private int electronicCardId;
}
