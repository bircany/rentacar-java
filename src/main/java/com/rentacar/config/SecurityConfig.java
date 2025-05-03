package com.rentacar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security configuration
 * Note: As this is a Swing application, Spring Security is not fully utilized.
 * It is only present here for utility classes such as password encoding.
 */
@Configuration
public class SecurityConfig {

    /**
     * Password encoder
     * @return PasswordEncoder object
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
} 