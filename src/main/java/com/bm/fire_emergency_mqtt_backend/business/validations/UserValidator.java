package com.bm.fire_emergency_mqtt_backend.business.validations;

import com.bm.fire_emergency_mqtt_backend.core.concerns.validations.Validator;
import com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions.ValidationException;

import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;

public final class UserValidator implements Validator<DbUser> {


    @Override
    public void validate(DbUser entity) throws ValidationException {
        invoke(
                validateEmail(entity.getEmail(),"")
        );
    }


}
