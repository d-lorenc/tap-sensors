package org.tapsensors.hub;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.tapsensors.hub.config.BaseSecurityConfig;

@Configuration
class TestSecurityConfig extends BaseSecurityConfig {
    @Override
    public void applyOauth2ResourceServer(HttpSecurity httpSecurity) throws Exception {
    }
}
