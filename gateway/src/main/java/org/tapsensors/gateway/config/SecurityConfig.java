package org.tapsensors.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity httpSecurity) {
        return httpSecurity.oauth2Login(Customizer.withDefaults())
                .authorizeExchange(ex -> {
                    ex.pathMatchers("/readyz", "/livez").permitAll();
                    ex.anyExchange().authenticated();
                })
                .build();
    }
}
