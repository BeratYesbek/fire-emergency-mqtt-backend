package com.bm.fire_emergency_mqtt_backend.core.security.jwt.token;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Token {

    private String accessToken;

    private Date expiry;

    private DbUser user;


    public Token(String accessToken, Date expiry) {
        this.accessToken = accessToken;
        this.expiry = expiry;
    }
}