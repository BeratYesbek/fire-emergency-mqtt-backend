package com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions;

public final class AuthorizationException extends SecurityBaseException {

    public AuthorizationException(String message) {
        super(message);
    }
}