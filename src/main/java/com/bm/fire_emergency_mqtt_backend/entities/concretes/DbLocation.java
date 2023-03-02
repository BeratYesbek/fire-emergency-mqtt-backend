package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.LOCATION_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateLocationColumnConstants.*;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateCommonColumnConstants.COL_ID;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = LOCATION_TABLE)
public class DbLocation extends DbEntity {

    @Column(name = COl_LATITUDE, nullable = false)
    private double latitude;

    @Column(name = COl_LONGITUDE, nullable = false)
    private double longitude;

    @JoinColumn(name = COL_ELECTRONIC_CARD_ID, referencedColumnName = COL_ID, nullable = false)
    private int electronicCardId;

    @Override
    public String toString() {
        return "DbLocation{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", electronicCardId=" + electronicCardId +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                '}';
    }
}
