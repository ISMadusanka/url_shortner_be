package com.urlshortner.urlshortner.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable) // Disable CSRF protection
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(
                                        "/api/short",          // Allow unauthenticated access to this endpoint
                                        "/user/register",      // Allow unauthenticated access to this endpoint
                                        "/user/verify",         // Allow unauthenticated access to this endpoint (query params allowed)
                                        "/{id}"                // Allow unauthenticated access for random short IDs

                                ).permitAll()
                                .anyRequest().authenticated() // Block all other endpoints unless authenticated
                )
                .formLogin(Customizer.withDefaults()) // Enable default form login
                .logout(Customizer.withDefaults()); // Enable logout with default configurations
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
