package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request;


import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.VacancyErrors;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record PostVacancyRequest(
    @NotBlank(message = VacancyErrors.vacancyNameMustBe2To75Char)
    @Size(min = 2, max = 75, message = VacancyErrors.vacancyNameMustBe2To75Char)
    String vacancyName,

    @NotBlank(message = VacancyErrors.descriptionMust1To5000Char)
    @Size(min = 1, max = 5000, message = VacancyErrors.descriptionMust1To5000Char)
    String description,

    @PositiveOrZero(message = VacancyErrors.maxAgeNotNegative)
    Integer maxAge,

    @Max(value = 30, message = VacancyErrors.minYearsExpRange)
    @PositiveOrZero(message = VacancyErrors.minYearsExpRange)
    Integer minimumYearsExperience,

    @Max(value = 1_000_000_000, message = VacancyErrors.salaryMax1Milliion)
    @PositiveOrZero(message = VacancyErrors.salaryNotNegative)
    Integer salary
) {}
