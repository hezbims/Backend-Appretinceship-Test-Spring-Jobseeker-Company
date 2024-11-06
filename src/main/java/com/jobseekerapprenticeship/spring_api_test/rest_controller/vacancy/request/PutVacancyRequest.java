package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request;

import org.bson.types.ObjectId;

public record PutVacancyRequest(
    // TODO : validasikan hexstring 24 character
    String vacancyId,
    String vacancyName,
    String description,
    Integer maxAge,
    Integer minimumYearsExperience,
    Integer salary,
    Boolean repost
) {}
