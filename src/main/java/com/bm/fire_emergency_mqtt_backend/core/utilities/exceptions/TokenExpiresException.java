package com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions;

public final class TokenExpiresException extends SecurityBaseException{
    public TokenExpiresException(String message) {
        super(message);
    }
}