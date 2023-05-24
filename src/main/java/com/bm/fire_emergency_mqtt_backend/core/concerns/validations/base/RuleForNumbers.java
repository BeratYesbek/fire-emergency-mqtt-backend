package com.bm.fire_emergency_mqtt_backend.core.concerns.validations.base;


import com.bm.fire_emergency_mqtt_backend.core.concerns.validations.results.ValidationErrorRuleResult;
import com.bm.fire_emergency_mqtt_backend.core.concerns.validations.results.ValidationRuleResult;
import com.bm.fire_emergency_mqtt_backend.core.concerns.validations.results.ValidationSuccessRuleResult;

public interface RuleForNumbers {

    default ValidationRuleResult graderThan(Number value, Number target, String message) {
        if (value.doubleValue() > target.doubleValue()) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult graderThanOrEquals(Number value, Number target, String message) {
        if (value.doubleValue() >= target.doubleValue()) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult lessThan(Number value, Number target, String message) {
        if (value.doubleValue() < target.doubleValue()) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }

    default ValidationRuleResult lessThanOrEquals(Number value, Number target, String message) {
        if (value.doubleValue() <= target.doubleValue()) {
            return new ValidationSuccessRuleResult("");
        }
        return new ValidationErrorRuleResult(message);
    }
}
