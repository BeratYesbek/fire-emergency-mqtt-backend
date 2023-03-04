package com.bm.fire_emergency_mqtt_backend.core.validation;

import lombok.Getter;

@Getter
public class ValidationRule {

    private final boolean success;
    private final String message;

    public ValidationRule(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
