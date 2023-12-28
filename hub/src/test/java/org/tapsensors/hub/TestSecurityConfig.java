package org.tapsensors.hub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.tapsensors.hub.config.security.BaseSecurityConfig;

@Configuration
class TestSecurityConfig extends BaseSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        this.applyOauth2ResourceServer(httpSecurity);
        this.applyEndpointAuthorization(httpSecurity);

        return httpSecurity.build();
    }
    @Override
    public void applyOauth2ResourceServer(HttpSecurity httpSecurity) throws Exception {
    }
}
