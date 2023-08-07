package com.example.server.jwt;

import com.example.server.dto.UserDTO;
import com.example.server.grpc.clients.UserClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * This class is responsible for creating beans for authentication and authorization.
 * Just a factory class for creating beans in general.
 */
@Configuration
public class SecurityBeanFactory {
    private final UserClient userClient;

    public SecurityBeanFactory(UserClient userClient) {
        this.userClient = userClient;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
           UserDTO userDTO = userClient.getUserByUsername(username);
              return new UserDetailsImpl(userDTO);
        };
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
