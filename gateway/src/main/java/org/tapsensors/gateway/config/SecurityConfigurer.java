package org.tapsensors.gateway.config;

import org.springframework.security.config.web.server.ServerHttpSecurity;

@FunctionalInterface
public interface SecurityConfigurer {
    void configure(ServerHttpSecurity httpSecurity) throws Exception;
}
