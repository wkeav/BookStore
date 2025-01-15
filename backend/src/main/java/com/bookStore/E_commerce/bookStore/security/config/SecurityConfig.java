package com.bookStore.E_commerce.bookStore.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    @Bean
    
    //encrypted password 
    public PasswordEncoder passwordEncoder() {  //PasswordEncoder is part of spring security, ensuring encoding & matching passwords 
        return new BCryptPasswordEncoder();
    }
}
