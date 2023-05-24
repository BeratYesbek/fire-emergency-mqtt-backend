package com.bm.fire_emergency_mqtt_backend.core.concerns.validations;


import com.bm.fire_emergency_mqtt_backend.core.concerns.validations.base.BaseRule;
import com.bm.fire_emergency_mqtt_backend.core.concerns.validations.results.ValidationRuleResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions.ValidationException;
import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;

import java.util.ArrayList;
import java.util.List;

public interface Validator<T extends DbEntity> extends BaseRule {
    void validate(T entity) throws ValidationException;

    default void invoke(final ValidationRuleResult... validationRules) throws ValidationException {
        List<String> errorMessages = new ArrayList<>();
        boolean exception = false;
        for (ValidationRuleResult item : validationRules) {
            if (!item.isSuccess()) {
                exception = true;
                errorMessages.add(item.getMessage());
            }
        }
        if (exception)
            throw new ValidationException(errorMessages, "Validation Exception");
    }
}
