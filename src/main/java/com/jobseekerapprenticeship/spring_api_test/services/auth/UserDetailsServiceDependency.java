package com.jobseekerapprenticeship.spring_api_test.services.auth;

import com.jobseekerapprenticeship.spring_api_test.repository.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class UserDetailsServiceDependency {
    private final UserRepository userRepository;

    @Bean
    public UserDetailsService getUserDetailsService(){
        return username ->
                userRepository.findByEmail(username)
                        .orElse(null);
    }
}
