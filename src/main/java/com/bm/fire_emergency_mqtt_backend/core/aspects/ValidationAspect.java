package com.bm.fire_emergency_mqtt_backend.core.aspects;

import com.bm.fire_emergency_mqtt_backend.core.annotations.Validation;
import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.annotations.AnnotationPackageConstants;
import com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions.ValidationException;
import com.bm.fire_emergency_mqtt_backend.core.validation.Validator;
import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

@Aspect
@Configuration
public class ValidationAspect {

    @SneakyThrows
    @Before(AnnotationPackageConstants.VALIDATION_ANNOTATION_PACKAGE)
    public void before(JoinPoint joinPoint) throws ValidationException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Validation validation = method.getAnnotation(Validation.class);

        Validator validator = validation.validator().newInstance();
        DbEntity dbEntity = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof DbEntity)
                dbEntity = (DbEntity) arg;
        }
        validator.validate(dbEntity);
    }
}
