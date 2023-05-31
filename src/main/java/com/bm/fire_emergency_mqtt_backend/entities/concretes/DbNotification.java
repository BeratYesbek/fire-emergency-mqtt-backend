package com.bm.fire_emergency_mqtt_backend.entities.concretes;

import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.*;

import javax.persistence.*;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateCommonColumnConstants.COL_ID;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateTableConstants.NOTIFICATION;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateNotificationColumnConstants.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = NOTIFICATION)
public class DbNotification extends DbEntity {


    @Column(name = COL_TITLE, nullable = false)
    private String title;

    @Column(name = COL_MESSAGE, nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = COL_USER_ID, referencedColumnName = COL_ID)
    private DbUser dbUser;

    @ManyToOne
    @JoinColumn(name = COL_CARD_ID, referencedColumnName = COL_ID)
    private DbElectronicCard dbElectronicCard;
}
