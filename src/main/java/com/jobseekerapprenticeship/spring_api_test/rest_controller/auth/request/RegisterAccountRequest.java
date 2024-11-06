package com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.request;

public record RegisterAccountRequest(
    String email,
    String password,
    String adminCreationSecret
) {}
