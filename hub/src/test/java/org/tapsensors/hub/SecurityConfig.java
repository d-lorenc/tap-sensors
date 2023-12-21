package org.tapsensors.hub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/livez").permitAll())
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .formLogin(formLogin -> {
                    formLogin.loginPage("/login");
                    formLogin.permitAll();
                });
        return httpSecurity.build();
    }


}
