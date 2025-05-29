package com.svar_proekt.weldproject.config;

import com.svar_proekt.weldproject.client.ItamClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        logger.info("зашел в бин security");
        security.formLogin(form -> form
                        .loginPage("/auth/login")
                        .loginProcessingUrl("/progressing")
                        .defaultSuccessUrl("/auth/hello", true)
                        .failureUrl("/auth/login?error"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login", "/auth/registration", "/itam/save", "/itam/getAll")
                        .permitAll()
                        .anyRequest().hasAnyRole("USER", "ADMIN"))
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/auth/login"))
                .csrf(csrf -> csrf.ignoringRequestMatchers("/itam/save", "/itam/getAll"));

        return security.build();

    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
