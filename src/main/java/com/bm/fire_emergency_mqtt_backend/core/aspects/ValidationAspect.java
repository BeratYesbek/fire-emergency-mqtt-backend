package com.bm.fire_emergency_mqtt_backend.core.aspects;

import com.bm.fire_emergency_mqtt_backend.core.annotations.Validation;
import com.bm.fire_emergency_mqtt_backend.core.concerns.validations.Validator;
import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.annotations.AnnotationPackageConstants;
import com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions.ValidationException;
import com.bm.fire_emergency_mqtt_backend.entities.abstracts.DbEntity;
import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.HashMap;

@Aspect
@Configuration
public class ValidationAspect {

    private static final HashMap<String, Validator> validators = new HashMap<>();

    @SneakyThrows
    @Before(AnnotationPackageConstants.VALIDATION_ANNOTATION_PACKAGE)
    public void before(JoinPoint joinPoint) throws ValidationException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Validation validation = method.getAnnotation(Validation.class);


        Validator validator = getValidatorInstance(validation.validator());
        DbEntity dbEntity = null;
        for (Object arg : joinPoint.getArgs()) {
            if (arg instanceof DbEntity)
                dbEntity = (DbEntity) arg;
        }
        validator.validate(dbEntity);
    }

    private Validator<?> getValidatorInstance(Class<?> validator) throws Exception {
        try {
            String key = validator.getName();
            Validator<?> instance = validators.get(key);
            if (instance != null)
                return instance;
            instance = (Validator<?>) validator.getDeclaredConstructor().newInstance();
            validators.put(key, instance);
            return instance;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());

        }
    }
}
