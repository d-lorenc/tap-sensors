package org.tapsensors.hub.config.security;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(value = "spring.security.oauth2.client.provider.appsso.issuer-uri")
public class SecurityConfig extends BaseSecurityConfig {
    @Bean
    JwtDecoder jwtDecoder(OAuth2ClientProperties oAuth2ClientProperties){
        String issuerUri = oAuth2ClientProperties.getProvider().get("appsso").getIssuerUri();
        return JwtDecoders.fromIssuerLocation(issuerUri);
    }
    @Override
    public void applyOauth2ResourceServer(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));
        httpSecurity.sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
    }
}
