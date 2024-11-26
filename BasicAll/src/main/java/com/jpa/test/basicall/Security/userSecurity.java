package com.jpa.test.basicall.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
@Configuration
public class userSecurity {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/home").permitAll();
                    registry.requestMatchers("/thanks").permitAll();
                    registry.requestMatchers("/next").permitAll();
                    registry.requestMatchers("/card").permitAll();
                    registry.requestMatchers("/admin/**").hasRole("ADMIN");

                    registry.anyRequest().authenticated();

                })
                .formLogin(AbstractAuthenticationFilterConfigurer::permitAll)
                .build();

    }
    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails admin= User.builder()
                .username("admin")
                .password("$2a$04$MMGjR9lqbXgGhmZ4m2INCuOnAcBV7yJWcZfjYVsMtZdvCSU8qSWjW")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(admin);


    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
}
