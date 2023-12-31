package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails MgMg = User.builder()
                .username("MgMg")
                .password("{noop}test123")
                .roles("ADMIN","USER")
                .build();

        UserDetails KyawKyaw = User.builder()
                .username("KyawKyaw")
                .password("{noop}test123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(MgMg,KyawKyaw);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http )throws Exception{
        http.authorizeHttpRequests( configure->
                configure
                        .requestMatchers(HttpMethod.GET,"/api/users").hasRole("USER")
                        .requestMatchers(HttpMethod.GET,"/api/users/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST,"/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/api/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/api/users/**").hasRole("ADMIN")
                );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf-> csrf.disable());
        return http.build();
    }


}
