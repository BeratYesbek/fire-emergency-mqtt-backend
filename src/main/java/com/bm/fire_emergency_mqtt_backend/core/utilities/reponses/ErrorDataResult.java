package com.bm.fire_emergency_mqtt_backend.core.utilities.reponses;

public class ErrorDataResult<T> extends DataResult<T> {
    public ErrorDataResult(T data, String message) {
        super(data, message, false);
    }
}
