package co.istad.chanchhaya.ecommerce.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain appFilterChain(HttpSecurity http) {
        // 1. Endpoints (secured, policy, permit)
        http.authorizeHttpRequests(endpoint -> endpoint
                .requestMatchers("/nacos/config").permitAll()
                .anyRequest().authenticated()
        );

        // 2. Stateless
        http.sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        // 3. Disable (Cross-site Request Forgery) CSRF
        http.csrf(AbstractHttpConfigurer::disable);

        // 4. Disable form login
        http.formLogin(AbstractHttpConfigurer::disable);

        // 5. Security mechanism
        http.oauth2ResourceServer(oauth2 -> oauth2
                .jwt(Customizer.withDefaults())
        );

        return http.build();
    }

}
