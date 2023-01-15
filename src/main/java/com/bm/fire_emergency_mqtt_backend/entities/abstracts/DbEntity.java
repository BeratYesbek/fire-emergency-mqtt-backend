package com.bm.fire_emergency_mqtt_backend.entities.abstracts;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
@Data
@MappedSuperclass
@ToString(of = {"id","createdAt"})
public abstract class DbEntity implements Serializable {

    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;


    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    protected Date createdAt;

}
