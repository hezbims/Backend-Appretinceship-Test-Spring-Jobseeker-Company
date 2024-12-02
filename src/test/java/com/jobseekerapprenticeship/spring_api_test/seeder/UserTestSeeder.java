package com.jobseekerapprenticeship.spring_api_test.seeder;

import com.jobseekerapprenticeship.spring_api_test.entity.User;
import com.jobseekerapprenticeship.spring_api_test.entity.UserType;
import com.jobseekerapprenticeship.spring_api_test.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@RequiredArgsConstructor
public class UserTestSeeder {
    private final UserRepository repository;

    public void execute() {
        var passwordEncoder = new BCryptPasswordEncoder();

        repository.insert(Arrays.asList(
            new User()
                .setEmail("admin@gmail.com")
                .setPassword(passwordEncoder.encode("ini-admin-123"))
                .setUserType(UserType.ADMIN),
            new User()
                .setEmail("non-admin@gmail.com")
                .setPassword(passwordEncoder.encode("ini-non-admin-123"))
                .setUserType(UserType.NON_ADMIN)
        ));
    }
}
