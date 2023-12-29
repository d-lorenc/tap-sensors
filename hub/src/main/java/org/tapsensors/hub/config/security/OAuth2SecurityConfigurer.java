package org.tapsensors.hub.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoders;

@Configuration
@ConditionalOnProperty(value = "spring.security.oauth2.client.provider.appsso.issuer-uri")
public class OAuth2SecurityConfigurer implements SecurityConfigurer{
    private final Logger log = LoggerFactory.getLogger(OAuth2SecurityConfigurer.class);

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        log.info("Configuring OAuth2 Resource Server to use JWTs");
        httpSecurity.oauth2ResourceServer(oauth -> oauth.jwt(Customizer.withDefaults()));
    }

    @Bean
    JwtDecoder jwtDecoder(OAuth2ClientProperties oAuth2ClientProperties){
        String issuerUri = oAuth2ClientProperties.getProvider().get("appsso").getIssuerUri();
        log.info("Creating JWT decoder for issuer: {}", issuerUri);
        return JwtDecoders.fromIssuerLocation(issuerUri);
    }

}
