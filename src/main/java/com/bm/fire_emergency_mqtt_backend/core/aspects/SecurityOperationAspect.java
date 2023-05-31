package com.bm.fire_emergency_mqtt_backend.core.aspects;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.bm.fire_emergency_mqtt_backend.core.concerns.security.AnnotationRolesResolver;
import com.bm.fire_emergency_mqtt_backend.core.concerns.security.jwt.JwtHelper;
import com.bm.fire_emergency_mqtt_backend.core.utilities.constants.annotations.AnnotationPackageConstants;
import com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions.AuthorizationException;
import com.bm.fire_emergency_mqtt_backend.core.utilities.exceptions.TokenExpiresException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import javax.security.sasl.AuthenticationException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Aspect
@Configuration
public class SecurityOperationAspect {

    private final HttpServletRequest request;
    private final JwtHelper jwtHelper;

    public SecurityOperationAspect(HttpServletRequest request, JwtHelper jwtHelper) {
        this.request = request;
        this.jwtHelper = jwtHelper;
    }

    @Before(AnnotationPackageConstants.SECURITY_ANNOTATION_PACKAGE)
    public void before(JoinPoint point) throws Exception {
        String token = request.getHeader("Authorization");

        if (token == null) {
            throw new AuthenticationException("You must log in");
        }

        DecodedJWT decodedJWT = jwtHelper.decodeJwtAndClaims(token);
        List<String> roles = decodedJWT.getClaim("roles").asList(String.class);
        String[] authoritativeRoles = AnnotationRolesResolver.resolveRoles(point);

        if (decodedJWT.getExpiresAt().getTime() < System.currentTimeMillis()) {
            throw new TokenExpiresException("Token is not valid");
        }

        for (String role : authoritativeRoles) {
            if (roles.contains(role)) {
                return;
            }
        }

        throw new AuthorizationException("You have no authorization");

    }
}
