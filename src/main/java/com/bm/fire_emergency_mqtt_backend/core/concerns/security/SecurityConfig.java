package com.bm.fire_emergency_mqtt_backend.core.concerns.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Enable all CORS
 * @author Berat Yesbek (Feanor)
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
        security.csrf().disable().authorizeRequests().anyRequest().permitAll();
        return security.build();
    }

}