package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response;

import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

public class VacancyWithIdNotFound extends MyApiRestResult<Object> {
    public VacancyWithIdNotFound(){
        super(
                "Vacancy dengan id yang anda minta tidak ditemukan",
                "VacancyWithIdNotFound",
                HttpStatus.NOT_FOUND
        );
    }
}
