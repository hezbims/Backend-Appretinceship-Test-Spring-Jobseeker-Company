package com.jobseekerapprenticeship.spring_api_test.rest_controller.auth;

import com.jobseekerapprenticeship.spring_api_test.entity.User;
import com.jobseekerapprenticeship.spring_api_test.entity.UserType;
import com.jobseekerapprenticeship.spring_api_test.repository.UserRepository;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._constant.ApiEndpointUri;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.request.RegisterAccountRequest;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.response.AdminCreationSecretWrongResponse;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.response.UserRegisteredResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping(ApiEndpointUri.auth)
@RestController
@RequiredArgsConstructor
public class AuthController {

    // Kode yang digunakan untuk membuat akun admin
    private static final String ADMIN_CREATION_SECRET = "ini-kode-yang-sangat-rahasia";

    final UserRepository userRepository;
    final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerAccount(
        @Valid @RequestBody RegisterAccountRequest request
    ){
        boolean isAdminCreation = false;
        if (request.adminCreationSecret() != null && !request.adminCreationSecret().isEmpty()){
            if (request.adminCreationSecret().equals(ADMIN_CREATION_SECRET))
                isAdminCreation = true;
            else
                return new AdminCreationSecretWrongResponse().toHttpResponse();
        }
        final User newUser = userRepository.insert(new User(
            request.email(),
            passwordEncoder.encode(request.password()),
            isAdminCreation ? UserType.ADMIN : UserType.NON_ADMIN
        ));

        return new UserRegisteredResponse(newUser).toHttpResponse();
    }
}
