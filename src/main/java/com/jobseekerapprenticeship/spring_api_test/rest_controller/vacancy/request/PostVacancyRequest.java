package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request;


public record PostVacancyRequest(
    String vacancyName,
    String description,
    Integer maxAge,
    int minimumYearsExperience,
    Integer salary
) {}
