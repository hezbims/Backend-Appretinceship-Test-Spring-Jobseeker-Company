package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy;

import com.jobseekerapprenticeship.spring_api_test.entity.Vacancy;
import com.jobseekerapprenticeship.spring_api_test.repository.VacancyRepository;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._constant.ApiEndpointUri;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request.PostVacancyRequest;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response.VacancyCreatedResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping(ApiEndpointUri.vacancy)
@RestController
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyRepository repository;

    @PostMapping("")
    public ResponseEntity<?> createNewVacancy(
        @Valid @RequestBody PostVacancyRequest request
    ){
        repository.insert(new Vacancy(
            request.vacancyName(),
            request.description(),
            request.maxAge(),
            request.minimumYearsExperience(),
            request.salary()
        ));

        return new VacancyCreatedResponse().toHttpResponse();
    }
}
