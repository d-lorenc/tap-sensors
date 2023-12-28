package org.tapsensors.hub.config.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.stereotype.Component;

@Component
public class SessionManagementConfigurer implements SecurityConfigurer{
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    }
}
