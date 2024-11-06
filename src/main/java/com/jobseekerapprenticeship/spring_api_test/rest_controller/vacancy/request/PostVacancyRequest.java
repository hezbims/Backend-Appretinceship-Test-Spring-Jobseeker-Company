package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request;


import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record PostVacancyRequest(
    @NotBlank(message = "Panjang vacancyName harus 2-75 karakter")
    @Size(min = 2, max = 75, message = "Panjang vacancyName harus 2-75 karakter")
    String vacancyName,

    @NotBlank(message = "Panjang description harus 1-5000 karakter")
    @Size(min = 1, max = 5000, message = "Panjang description harus 1-5000 karakter")
    String description,

    @PositiveOrZero(message = "maxAge harus >= 0")
    Integer maxAge,

    @PositiveOrZero(message = "minimumYearsExperience harus >= 0")
    Integer minimumYearsExperience,

    @Max(value = 1_000_000_000, message = "Maksimal salary adalah 1 milyar")
    @PositiveOrZero(message = "salary tidak boleh negatif")
    Integer salary
) {}
