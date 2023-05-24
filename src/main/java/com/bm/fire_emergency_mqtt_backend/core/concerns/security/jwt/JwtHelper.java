package com.bm.fire_emergency_mqtt_backend.core.concerns.security.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.bm.fire_emergency_mqtt_backend.core.concerns.security.jwt.token.Token;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.DataResult;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;


/**
 * JWT Helper that contains token creator and jwt claim decoder
 * @author Berat Yesbek (Feanor)
 */
public interface JwtHelper {
    Token createToken(DbUser user, String[] roles, String url);
    DecodedJWT decodeJwtAndClaims(String token);
    DataResult<Token> validateToken(String token);
}