package co.istad.chanchhaya.ecommerce.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class GatewaySecurityConfig {

    @Bean
    SecurityWebFilterChain gatewayFilterChain(ServerHttpSecurity http) {

        http.authorizeExchange(exchange -> exchange
                .pathMatchers("/auth/**").authenticated()
                .anyExchange().permitAll());

        http.csrf(ServerHttpSecurity.CsrfSpec::disable);
        http.cors(ServerHttpSecurity.CorsSpec::disable);
        http.oauth2Login(Customizer.withDefaults());

        return http.build();
    }

}
