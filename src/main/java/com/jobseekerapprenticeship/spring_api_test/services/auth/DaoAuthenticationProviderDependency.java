package com.jobseekerapprenticeship.spring_api_test.services.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DaoAuthenticationProviderDependency {
    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bcryptPasswordEncoder;

    @Bean
    public DaoAuthenticationProvider getDaoAuthenticationProvider(){
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(bcryptPasswordEncoder);

        return authProvider;

    }
}
