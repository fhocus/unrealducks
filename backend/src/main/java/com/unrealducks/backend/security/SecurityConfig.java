package com.unrealducks.backend.security;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.security.annotation.web.builders.HttpSecurity;
import org.springframework.security.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return HttpSecurity
            .formLogin(httpForm -> 
                httpForm.loginPage("/login").permitAll()
            ) 

            .authorizeRequests(registry -> {
                registry.requestMatchers("/req/signup").permitAll();
                registry.anyRequest().authenticated();
            });
    }
}
