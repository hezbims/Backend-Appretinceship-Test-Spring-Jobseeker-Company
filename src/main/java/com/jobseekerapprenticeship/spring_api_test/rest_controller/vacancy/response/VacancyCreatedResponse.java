package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response;

import com.jobseekerapprenticeship.spring_api_test.entity.Vacancy;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

public class VacancyCreatedResponse extends MyApiRestResult<Vacancy> {
    public VacancyCreatedResponse(Vacancy newVacancy){
        super(
        "Berhasil membuat lowongan baru",
                "VacancyCreated",
                HttpStatus.CREATED,
                newVacancy
        );
    }
}
