package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.ELECTRONIC_CARD_TABLE;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateElectronicCardColumnContants.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = ELECTRONIC_CARD_TABLE)
public class DbElectronicCard extends DbEntity {

    @Column(name = COL_ELECTRONIC_CARD_UUID,nullable = false)
    private String electronicCardUUID;

    @Column(name = COL_QR_CODE,nullable = false)
    private String qrCode;

}
