package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response;

import com.jobseekerapprenticeship.spring_api_test.entity.Vacancy;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

public class VacancyUpdatedResponse extends MyApiRestResult<Vacancy> {
    public VacancyUpdatedResponse(Vacancy vacancy){
        super(
                "Berhasil memperbarui data lowongan kerja",
                "VacancyUpdated",
                HttpStatus.OK,
                vacancy
        );
    }
}
