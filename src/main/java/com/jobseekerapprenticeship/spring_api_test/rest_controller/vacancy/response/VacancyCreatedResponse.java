package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response;

import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

public class VacancyCreatedResponse extends MyApiRestResult<Object> {
    public VacancyCreatedResponse(){
        super(
        "Berhasil membuat lowongan baru",
                "VacancyCreated",
                HttpStatus.CREATED
        );
    }
}
