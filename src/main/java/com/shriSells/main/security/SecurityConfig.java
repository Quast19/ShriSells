package com.shriSells.main.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
    public class SecurityConfig {

        @Autowired
        private GoogleJWTAuthFilter googleJWTAuthFilter;

        private static final String[] SWAGGER_WHITELIST = {
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/swagger-ui.html"
        };

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf(AbstractHttpConfigurer::disable)
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers(SWAGGER_WHITELIST).permitAll()
                            //.requestMatchers("/*").permitAll()   // open endpoints
                            .anyRequest().authenticated()
                    )
                    .addFilterBefore(googleJWTAuthFilter,
                            org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

            return http.build();
        }
    }
