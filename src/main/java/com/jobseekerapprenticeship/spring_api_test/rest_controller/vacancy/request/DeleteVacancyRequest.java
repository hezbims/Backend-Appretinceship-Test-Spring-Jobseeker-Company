package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request;

public record DeleteVacancyRequest(
    // TODO : validasikan hexstring 24 character
    String vacancyId
) {}
