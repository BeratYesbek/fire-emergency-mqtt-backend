package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.List;
import java.util.UUID;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.ELECTRONIC_CARD_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateElectronicCardColumnConstants.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ELECTRONIC_CARD_TABLE)
public class DbElectronicCard extends DbEntity {

    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = COL_ELECTRONIC_CARD_UUID, columnDefinition = "VARCHAR(255)", unique = true, nullable = false)
    private String electronicCardUUID;

    @Column(name = COL_QR_CODE, nullable = false)
    private String qrCode;

    @OneToOne(mappedBy = "dbElectronicCard", fetch = FetchType.LAZY)
    private DbElectronicCardUser dbElectronicCardUser;

    @OneToMany(mappedBy = "dbElectronicCard", fetch = FetchType.LAZY)
    private List<DbNotification> dbNotificationList;

    @PrePersist
    private void assignUIID() {
        electronicCardUUID = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "DbElectronicCard{" +
                "id=" + id +
                ", electronicCardUUID='" + electronicCardUUID + '\'' +
                ", qrCode='" + qrCode + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                '}';
    }
}
