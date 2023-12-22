package org.tapsensors.hub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    @Order(2)
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .oauth2Login(customizer -> customizer
                        .defaultSuccessUrl("/dashboard"))
                .authorizeHttpRequests(http -> http.requestMatchers("/readyz", "/livez", "/").permitAll())
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated());

        return httpSecurity.build();
    }
}
