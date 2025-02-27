package com.example.security.config;

import org.apache.catalina.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
            http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests( authorize ->
                authorize
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults());
            // .sessionManagement( session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS ));
            return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration congfig) throws Exception{
        return congfig.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider provider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        authenticationProvider.setUserDetailsService(userDetailsService);
        return authenticationProvider;
    }
}
