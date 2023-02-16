package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.UUID;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.ELECTRONIC_CARD_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateElectronicCardColumnContants.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ELECTRONIC_CARD_TABLE)
public class DbElectronicCard extends DbEntity {

    @GeneratedValue(generator = "uuid2",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid2",strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = COL_ELECTRONIC_CARD_UUID,columnDefinition = "VARCHAR(255)", unique = true, nullable = false)
    private String electronicCardUUID;

    @Column(name = COL_QR_CODE,nullable = false)
    private String qrCode;





    @PrePersist
    private void assignUIID(){
        electronicCardUUID = UUID.randomUUID().toString();
    }
}
