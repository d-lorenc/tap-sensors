package org.tapsensors.gateway.config;

import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationConfigurer implements SecurityConfigurer{
    @Override
    public void configure(ServerHttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeExchange(ex -> {
            ex.pathMatchers("/readyz", "/livez").permitAll();
            ex.anyExchange().authenticated();
        });
    }
}
