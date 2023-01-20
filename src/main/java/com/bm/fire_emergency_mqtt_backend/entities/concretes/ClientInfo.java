package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.UUID;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.CLIENT_INFO_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateClientInfoColumnConstants.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = CLIENT_INFO_TABLE)
public class ClientInfo extends DbEntity {

    @Column(name = COl_LATITUDE, nullable = false)
    private double latitude;

    @Column(name = COl_LONGITUDE, nullable = false)
    private double longitude;

    @Column(name = COl_PHONE_NAME, nullable = false)
    private String phoneName;

    @Column(name = COl_PHONE_BRAND, nullable = false)
    private String phoneBrand;

    @Column(name = COl_OPERATING_SYSTEM, nullable = false)
    private String operatingSystem;

    @Column(name = COl_PHONE_UUID, nullable = false)
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String phoneUUID;


//    @PrePersist
//    private void assignUIID(){
//        phoneUUID = UUID.randomUUID().toString();
//    }
}