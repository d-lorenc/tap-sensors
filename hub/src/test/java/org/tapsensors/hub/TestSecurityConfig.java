package org.tapsensors.hub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.tapsensors.hub.config.BaseSecurityConfig;

import static org.mockito.Mockito.mock;

@Configuration
class TestSecurityConfig extends BaseSecurityConfig {
    @Bean
    JwtDecoder jwtDecoder(){
        return mock(JwtDecoder.class);
    }
    @Override
    public void applyOauth2ResourceServer(HttpSecurity httpSecurity) throws Exception {
    }
}
