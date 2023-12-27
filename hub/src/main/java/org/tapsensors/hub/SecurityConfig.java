package org.tapsensors.hub;

import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    JwtDecoder jwtDecoder(OAuth2ClientProperties oAuth2ClientProperties){
        String issuerUri = oAuth2ClientProperties.getProvider().get("appsso").getIssuerUri();
        return JwtDecoders.fromIssuerLocation(issuerUri);
    }
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .oauth2ResourceServer(resourceServer -> resourceServer.jwt(Customizer.withDefaults()))
                .authorizeHttpRequests(http ->
                        http.requestMatchers("/readyz", "livez").permitAll()
                                .anyRequest().authenticated());
        return httpSecurity.build();
    }
}
