package com.bm.fire_emergency_mqtt_backend.core.concerns.validations.results;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationSuccessRuleResult extends ValidationRuleResult{
    public ValidationSuccessRuleResult(String message) {
        super(true, message);
    }
}
