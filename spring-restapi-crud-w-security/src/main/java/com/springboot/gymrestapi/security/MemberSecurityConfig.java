package com.springboot.gymrestapi.security;

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
public class MemberSecurityConfig {
    

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){

        // We are creating Users that will be able to acess the data over HTTP requests 

        // These are the only users that can access the endpoints 

        // so lets create user objects and assign them the given credentials 
        UserDetails guest = User.builder()
            .username("guest")
            .password("{noop}123")
            .roles("GUEST")
            .build();

        UserDetails bob = User.builder()
            .username("bob")
            .password("{noop}123")
            .roles("EMPLOYEE")
            .build();
            
        UserDetails sherry = User.builder()
            .username("shery")
            .password("{noop}123")
            .roles("EMPLOYEE", "MANAGER")
            .build();

        UserDetails steve_jobs = User.builder()
            .username("steve")
            .password("{noop}123")
            .roles("EMPLOYEE", "MANAGER", "ADMIN")
            .build();

        return new InMemoryUserDetailsManager(guest, bob, sherry, steve_jobs);

    }

    // Now this poses a question, what if we only want some people/"employees"
    // to acces SOME endpoints. Lets assign which role is able to see which HTTP operations/endpoints 


    // NOTE to self -> .authorizeHttpRequests allows us to give access to certain HTTP methods
    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                .requestMatchers(HttpMethod.GET, "/api/members").hasAnyRole("GUEST", "EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/members/**").hasAnyRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/members").hasAnyRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/members").hasAnyRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/members/**").hasAnyRole("ADMIN")

        );

        http.httpBasic(Customizer.withDefaults());

        //Lets disable the CRSF since we do not need it
        // NOTE: we do not need the CRSF since we are making a 
        //  stateless API
        
        http.csrf(csrf -> csrf.disable());


        // just return/builds the Security Filter Chain and filters it
        return http.build();

    }






}
