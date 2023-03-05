package com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions;

import lombok.Getter;

import java.util.List;

@Getter
public class BaseException extends Exception {
    protected final List<String> errorMessages;


    public BaseException(List<String> errorMessages, String message) {
        super(message);
        this.errorMessages = errorMessages;
    }
}
