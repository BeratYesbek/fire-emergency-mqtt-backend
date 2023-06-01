package com.bm.fire_emergency_mqtt_backend.mqtt;

import java.util.concurrent.Callable;

public interface MqttMessageSender<T> extends Callable<Void> {
    void setValue(T value);

    void setTopic(String value);
}
