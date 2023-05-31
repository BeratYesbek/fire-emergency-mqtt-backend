package com.bm.fire_emergency_mqtt_backend.core.concerns.security;

import com.bm.fire_emergency_mqtt_backend.core.annotations.SecurityOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

public final class AnnotationRolesResolver {

    public static String[] resolveRoles(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SecurityOperation securityAnnotation = method.getAnnotation(SecurityOperation.class);
        String[] security = securityAnnotation.security();
        return security;
    }
}