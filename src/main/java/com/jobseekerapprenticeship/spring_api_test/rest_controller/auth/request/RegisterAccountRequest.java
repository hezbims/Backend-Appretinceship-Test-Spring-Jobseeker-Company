package com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterAccountRequest(
    @NotBlank(message = "email tidak valid")
    @Email(message = "email tidak valid")
    String email,

    @NotBlank(message = "password harus terdiri dari 8-16 karakter")
    @Size(min = 8, max = 16, message = "password harus terdiri dari 8-16 karakter")
    String password,
    String adminCreationSecret
) {}
