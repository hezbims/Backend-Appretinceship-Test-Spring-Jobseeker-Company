package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request;

import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.VacancyErrors;
import com.jobseekerapprenticeship.spring_api_test.services.validation.HexString;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record PutVacancyRequest(
    @HexString(message = VacancyErrors.vacancyid24CharHexString)
    String vacancyId,

    @NotBlank(message = VacancyErrors.vacancyNameMustBe2To75Char)
    @Size(min = 2, max = 75, message = VacancyErrors.vacancyNameMustBe2To75Char)
    String vacancyName,

    @NotBlank(message = VacancyErrors.descriptionMust1To5000Char)
    @Size(min = 1 , max = 5000, message = VacancyErrors.descriptionMust1To5000Char)
    String description,

    @PositiveOrZero(message = VacancyErrors.maxAgeNotNegative)
    Integer maxAge,

    @Max(value = 30, message = VacancyErrors.minYearsExpRange)
    @PositiveOrZero(message = VacancyErrors.minYearsExpRange)
    Integer minimumYearsExperience,

    @PositiveOrZero(message = VacancyErrors.salaryNotNegative)
    Integer salary,

    @NotNull(message = "Isikan field repost dengan nilai true atau false")
    Boolean repost
) {}
