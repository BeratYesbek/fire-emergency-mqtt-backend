package com.bm.fire_emergency_mqtt_backend.entities.abstracts;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateCommonColumnConstants.COL_ID;
import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.HibernateCommonColumnConstants.COL_CREATED_AT;

@Getter
@Setter
@MappedSuperclass
public abstract class DbEntity implements Serializable {
    public static Boolean DEFAULT_DELETED_VALUE = false;

    @Id
    @Access(AccessType.PROPERTY)
    @Column(name = COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Version
    protected int version;

    @Column(name = "deleted", nullable = false)
    protected Boolean deleted = DEFAULT_DELETED_VALUE;

    @Column(name = COL_CREATED_AT, nullable = false)
    @CreationTimestamp
    protected Date createdAt;

}
