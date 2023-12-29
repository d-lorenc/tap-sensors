package org.tapsensors.hub.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final List<SecurityConfigurer> securityConfigurers;

    public SecurityConfig(List<SecurityConfigurer> securityConfigurers) {
        this.securityConfigurers = securityConfigurers;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        for (SecurityConfigurer configurer : this.securityConfigurers) {
            configurer.configure(httpSecurity);
        }

        return httpSecurity.build();
    }


}
