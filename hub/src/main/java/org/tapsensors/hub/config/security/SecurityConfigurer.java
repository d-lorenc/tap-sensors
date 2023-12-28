package org.tapsensors.hub.config.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@FunctionalInterface
public interface SecurityConfigurer {
    void configure(HttpSecurity httpSecurity) throws Exception;
}
