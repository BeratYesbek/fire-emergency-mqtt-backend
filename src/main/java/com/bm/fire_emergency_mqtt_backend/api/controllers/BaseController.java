package com.bm.fire_emergency_mqtt_backend.api.controllers;

import com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions.BaseException;
import com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions.ValidationException;
import com.bm.fire_emergency_mqtt_backend.core.utilities.reponses.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {
    @ExceptionHandler({ValidationException.class, Exception.class})
    protected ResponseEntity<ExceptionResult> handleException(Exception exception) {
        BaseException baseException = (BaseException) exception.getCause();
        return new ResponseEntity<>(
                new ExceptionResult(baseException.getMessage(), baseException.getErrorMessages()),
                HttpStatus.OK
        );
    }
}
