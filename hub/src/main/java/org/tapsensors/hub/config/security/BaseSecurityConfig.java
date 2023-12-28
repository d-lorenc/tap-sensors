package org.tapsensors.hub.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public abstract class BaseSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        applyOauth2ResourceServer(httpSecurity);
        applyEndpointAuthorization(httpSecurity);

        return httpSecurity.build();
    }

    void applyEndpointAuthorization(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(http ->
                http.requestMatchers("/readyz", "/livez").permitAll()
                        .anyRequest().authenticated());
    }
    public abstract void applyOauth2ResourceServer(HttpSecurity httpSecurity) throws Exception;
}
