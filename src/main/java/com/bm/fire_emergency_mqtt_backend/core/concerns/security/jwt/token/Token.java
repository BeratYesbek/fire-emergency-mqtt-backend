package com.bm.fire_emergency_mqtt_backend.core.concerns.security.jwt.token;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Token {

    private String accessToken;

    private Date expiry;

    private DbUser user;


    public Token(String accessToken, Date expiry) {
        this.accessToken = accessToken;
        this.expiry = expiry;
    }
}