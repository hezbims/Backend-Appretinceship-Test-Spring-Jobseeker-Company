package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy;

import com.jobseekerapprenticeship.spring_api_test.entity.Vacancy;
import com.jobseekerapprenticeship.spring_api_test.repository.VacancyRepository;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._constant.ApiEndpointUri;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request.PostVacancyRequest;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request.PutVacancyRequest;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response.VacancyCreatedResponse;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response.VacancyUpdatedResponse;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response.VacancyWithIdNotFound;

import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PutMapping("")
    public ResponseEntity<?> updateVacancy(
        @Valid @RequestBody PutVacancyRequest request
    ){
        final Vacancy oldVacancy = repository.findById(new ObjectId(request.vacancyId()))
                .orElse(null);
        if (oldVacancy == null)
            return new VacancyWithIdNotFound().toHttpResponse();

        oldVacancy.setVacancyName(request.vacancyName());
        oldVacancy.setDescription(request.description());
        oldVacancy.setMaximumAge(request.maxAge());
        oldVacancy.setMinimumYearsExperience(request.minimumYearsExperience());
        oldVacancy.setSalary(request.salary());

        if (request.repost())
            oldVacancy.setExpiryDate(Vacancy.vacancyExpirationDurationMillis + System.currentTimeMillis());

        final Vacancy newVacancy = repository.save(oldVacancy);

        return new VacancyUpdatedResponse(newVacancy).toHttpResponse();
    }
}
