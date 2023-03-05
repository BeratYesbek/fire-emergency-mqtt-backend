package com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidationException extends BaseException {

    public ValidationException(List<String> errorMessages, String message) {
        super(errorMessages, message);
    }
}
