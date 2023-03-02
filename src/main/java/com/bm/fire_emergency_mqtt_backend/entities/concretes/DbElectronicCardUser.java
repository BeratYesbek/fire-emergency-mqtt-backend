package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.UUID;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateCommonColumnConstants.CHARACTER_LENGTH_FOR_NAME;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateCommonColumnConstants.COL_ID;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.ELECTRONIC_CARD_USER_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateDbElectronicCardUserColumnConstants.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ELECTRONIC_CARD_USER_TABLE)
public class DbElectronicCardUser extends DbEntity {

    @Column(name = COL_NAME, nullable = false, length = CHARACTER_LENGTH_FOR_NAME)
    private String name;

    @GeneratedValue(generator = "uuid2", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = COL_UUID, columnDefinition = "VARCHAR(255)", unique = true, nullable = false)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = COL_USER_ID, referencedColumnName = COL_ID)
    private DbUser dbUser;

    @PrePersist
    private void assignUIID() {
        uuid = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "DbElectronicCardUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                ", version=" + version +
                ", deleted=" + deleted +
                ", createdAt=" + createdAt +
                '}';
    }
}
