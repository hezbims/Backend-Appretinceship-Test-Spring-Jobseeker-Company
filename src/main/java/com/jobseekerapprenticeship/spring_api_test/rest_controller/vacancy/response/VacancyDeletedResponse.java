package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response;

import com.jobseekerapprenticeship.spring_api_test.entity.Vacancy;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

public class VacancyDeletedResponse extends MyApiRestResult<Vacancy> {
    public VacancyDeletedResponse(Vacancy vacancy){
        super(
                "Berhasil menghapus vacancy",
                "VacancyDeleted",
                HttpStatus.OK,
                vacancy
        );
    }
}
