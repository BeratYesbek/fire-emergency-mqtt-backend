package com.bm.fire_emergency_mqtt_backend.core.annotations;


import com.bm.fire_emergency_mqtt_backend.core.validation.Validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validation {
    Class<? extends Validator> validator();
}
