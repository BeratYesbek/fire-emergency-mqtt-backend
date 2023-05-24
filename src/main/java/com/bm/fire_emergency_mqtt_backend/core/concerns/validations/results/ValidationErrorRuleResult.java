package com.bm.fire_emergency_mqtt_backend.core.concerns.validations.results;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ValidationErrorRuleResult extends ValidationRuleResult {
    public ValidationErrorRuleResult(String message) {
        super(false, message);
    }
}
