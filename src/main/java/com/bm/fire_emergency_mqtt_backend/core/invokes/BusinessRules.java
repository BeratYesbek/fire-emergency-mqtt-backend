package com.bm.fire_emergency_mqtt_backend.core.invokes;

import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.Result;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.SuccessResult;
import com.bm.fire_emergency_mqtt_backend.core.utilities.rules.Rule;
/**
 * This class invoke custom business rules when run method is called.
 * @author Berat Yesbek (Feanor)
 * */
public class BusinessRules {

    /**
     * Method is taken parameters as methods of  business rule that extended Rule class
     * @param methods
     * @return Result
     * @see Rule
     */
    public static Result run(Result... methods) {
        for (Result item : methods) {
            if (!item.isSuccess()) {
                return item;
            }
        }
        return new SuccessResult("");
    }
}
