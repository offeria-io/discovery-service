package offeria.discovery_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

/**
 * Security configuration for the Eureka Server.
 * Basic Authentication is used for the dashboard and service registration.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // CSRF protection must be disabled for Eureka client registration to work
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // Allow actuator endpoints for monitoring
                .requestMatchers("/actuator/**").permitAll()
                // All other requests require authentication
                .anyRequest().authenticated()
            )
            // Enable HTTP Basic authentication
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
