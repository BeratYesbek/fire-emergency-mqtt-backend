package com.bm.fire_emergency_mqtt_backend.core.utilities.reponses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class DataResult<T> extends Result {
    T data;

    public DataResult(T data, String message, boolean success) {
        super(message, success);
        this.data = data;
    }
}
