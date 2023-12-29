package org.tapsensors.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import java.util.List;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    private List<SecurityConfigurer> securityConfigurers;
    public SecurityConfig(List<SecurityConfigurer> securityConfigurers) {
        this.securityConfigurers = securityConfigurers;
    }

    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity httpSecurity) throws Exception {
        for (SecurityConfigurer configurer : securityConfigurers) {
            configurer.configure(httpSecurity);
        }
        return httpSecurity.build();
    }
}
