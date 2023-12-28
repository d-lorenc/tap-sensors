package org.tapsensors.hub.config.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class EndpointSecurityConfigurer implements SecurityConfigurer{

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)));
        httpSecurity.authorizeHttpRequests(http ->
                http.requestMatchers("/readyz", "/livez").permitAll()
                        .anyRequest().authenticated());
    }
}