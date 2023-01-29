package com.bm.fire_emergency_mqtt_backend.core.utilities.reponses;

public class SuccessResult extends Result {
    public SuccessResult(String message) {
        super(message, true);
    }
}
