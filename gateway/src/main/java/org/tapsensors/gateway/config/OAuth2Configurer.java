package org.tapsensors.gateway.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("spring.security.oauth2.client.registration.appsso.client-id")
public class OAuth2Configurer implements SecurityConfigurer{
    @Override
    public void configure(ServerHttpSecurity httpSecurity) throws Exception {
        httpSecurity.oauth2Login(Customizer.withDefaults());
    }
}
