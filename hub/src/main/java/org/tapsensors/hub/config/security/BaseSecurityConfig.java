package org.tapsensors.hub.config.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

public abstract class BaseSecurityConfig {
    protected void applyEndpointAuthorization(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)));
        httpSecurity.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        httpSecurity.authorizeHttpRequests(http ->
                http.requestMatchers("/readyz", "/livez").permitAll()
                        .anyRequest().authenticated());
    }
    public abstract void applyOauth2ResourceServer(HttpSecurity httpSecurity) throws Exception;
}
