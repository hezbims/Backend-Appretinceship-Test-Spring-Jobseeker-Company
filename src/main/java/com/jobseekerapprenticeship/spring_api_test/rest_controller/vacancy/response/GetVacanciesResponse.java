package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response;

import com.jobseekerapprenticeship.spring_api_test.entity.Vacancy;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

import java.util.List;

public class GetVacanciesResponse extends MyApiRestResult<List<Vacancy>> {
    public GetVacanciesResponse(List<Vacancy> vacancyList){
        super(
            "Berhasil mendapatkan lowongan kerja",
            "GetVacanciesSucced",
                HttpStatus.OK,
                vacancyList
        );
    }
}
