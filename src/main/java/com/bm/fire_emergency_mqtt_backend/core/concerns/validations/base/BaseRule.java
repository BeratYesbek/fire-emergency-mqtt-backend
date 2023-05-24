package com.bm.fire_emergency_mqtt_backend.core.concerns.validations.base;


import com.bm.fire_emergency_mqtt_backend.core.concerns.validations.results.ValidationErrorRuleResult;
import com.bm.fire_emergency_mqtt_backend.core.concerns.validations.results.ValidationRuleResult;
import com.bm.fire_emergency_mqtt_backend.core.concerns.validations.results.ValidationSuccessRuleResult;

public interface BaseRule extends RuleForStrings, RuleForNumbers {

    default ValidationRuleResult notNull(Object object, String message) {
        if (object != null) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult notEmpty(String value, String message) {
        if (value.isEmpty())
            return new ValidationErrorRuleResult(message);
        return new ValidationSuccessRuleResult("");
    }
}
