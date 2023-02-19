package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

import java.util.UUID;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.CLIENT_INFO_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateClientInfoColumnConstants.*;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateCommonColumnConstants.COL_ID;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = CLIENT_INFO_TABLE)
@Where(clause = "deleted is false")
@SQLDelete(sql = "UPDATE public.client_info set DELETED = TRUE WHERE ID=? and VERSION=?")
public class DbClientInfo extends DbEntity {

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

    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = COl_PHONE_UUID, columnDefinition = "VARCHAR(255)", unique = true, nullable = false)
    private String phoneUUID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = COL_USER_ID, referencedColumnName = COL_ID, nullable = false)
    private DbUser dbUser;

    @PrePersist
    private void assignUIID() {
        phoneUUID = UUID.randomUUID().toString();
    }
}
