package com.bm.fire_emergency_mqtt_backend.business.validations;

import com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions.ValidationException;
import com.bm.fire_emergency_mqtt_backend.core.validation.ValidationRule;
import com.bm.fire_emergency_mqtt_backend.core.validation.Validator;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;

public final class UserValidator implements Validator<DbUser> {


    @Override
    public void validate(DbUser entity) throws ValidationException {
        invoke(
                emailNotNull(entity.getEmail()),
                fullNameNotNull(entity.getFullName())
        );
    }

    private ValidationRule emailNotNull(String email) {
        return new ValidationRule(!email.isEmpty(), "Email cannot be empty");
    }

    private ValidationRule fullNameNotNull(String fullName) {
        return new ValidationRule(!fullName.isEmpty(), "Full name cannot be empty");
    }

    private ValidationRule usernameNotNull(String userName) {
        return new ValidationRule(!userName.isEmpty(), "Username cannot be empty");
    }

}
