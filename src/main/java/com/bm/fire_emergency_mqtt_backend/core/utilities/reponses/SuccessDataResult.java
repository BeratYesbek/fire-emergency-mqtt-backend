package com.bm.fire_emergency_mqtt_backend.core.utilities.reponses;


public class SuccessDataResult<T> extends DataResult<T> {

    public SuccessDataResult(T data, String message) {
        super(data, message, true);
    }
}
