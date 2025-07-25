package com.example.videostreamingapp.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF (needed for POST requests)
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/api/auth/**",           // Existing
                    "/api/users/register",    // Add this ✅
                    "/api/users/login",       // (Optional: for login later)
                    "/error"                  // Allow error page access
                ).permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form.disable())
            .logout(logout -> logout.disable());

        return http.build();
    }
}
