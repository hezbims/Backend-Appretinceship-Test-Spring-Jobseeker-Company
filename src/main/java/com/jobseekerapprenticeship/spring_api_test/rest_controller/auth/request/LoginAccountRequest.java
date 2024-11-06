package com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.request;

public record LoginAccountRequest(
    String email,
    String password
) { }
