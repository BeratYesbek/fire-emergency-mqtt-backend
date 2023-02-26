package com.bm.fire_emergency_mqtt_backend.business.rules;

import com.bm.fire_emergency_mqtt_backend.business.services.UserService;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.*;
import com.bm.fire_emergency_mqtt_backend.entities.concretes.DbUser;

import static com.bm.fire_emergency_mqtt_backend.core.utilities.constants.messages.AuthMessages.*;

public class AuthRules {

    public Result checkUsernameHasSomeoneElse(String username, UserService userService) {
        DataResult<DbUser> userDataResult = userService.findByUsername(username);
        if (userDataResult.isSuccess()) {
            return new ErrorResult(USERNAME_HAS_ALREADY_TAKEN);
        }
        return new SuccessResult(USERNAME_AVAILABLE);
    }

    public Result checkEmailHasSomeoneElse(String email, UserService userService) {
        DataResult<DbUser> userDataResult = userService.findByEmail(email);
        if (userDataResult.isSuccess()) {
            return new ErrorResult(EMAIL_HAS_ALREADY_TAKEN);
        }
        return new SuccessResult(EMAIL_AVAILABLE);
    }
}
