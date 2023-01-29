package com.bm.fire_emergency_mqtt_backend.core.utilities.reponses;

public class ErrorResult extends Result {
    public ErrorResult(String message) {
        super(message, false);
    }
}
