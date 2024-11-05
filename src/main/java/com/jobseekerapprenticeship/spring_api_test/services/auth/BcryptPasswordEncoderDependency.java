package com.jobseekerapprenticeship.spring_api_test.services.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BcryptPasswordEncoderDependency {
    @Bean
    public BCryptPasswordEncoder getBcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
