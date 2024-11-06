package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request;

import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.VacancyErrors;
import com.jobseekerapprenticeship.spring_api_test.services.validation.HexString;

public record DeleteVacancyRequest(
    @HexString(message = VacancyErrors.vacancyid24CharHexString)
    String vacancyId
) {}
