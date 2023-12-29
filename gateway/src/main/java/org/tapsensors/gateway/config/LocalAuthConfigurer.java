package org.tapsensors.gateway.config;

import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.stereotype.Component;

@Component
@Profile("local")
public class LocalAuthConfigurer implements SecurityConfigurer{
    @Override
    public void configure(ServerHttpSecurity httpSecurity) throws Exception {
        httpSecurity.anonymous(Customizer.withDefaults());
    }
}
