package com.bm.fire_emergency_mqtt_backend.core.utilities.reponses;

import java.util.List;

public class ExceptionResult extends ErrorResult {

    private List<String> errorDetails;

    public ExceptionResult(String message, List<String> errorDetails) {
        super(message);
        this.errorDetails = errorDetails;
    }

    public List<String> getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(List<String> errorDetails) {
        this.errorDetails = errorDetails;
    }
}
