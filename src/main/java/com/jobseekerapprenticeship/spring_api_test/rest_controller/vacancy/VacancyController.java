package com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy;

import com.jobseekerapprenticeship.spring_api_test.configuration.timeProvider.ITimeProvider;
import com.jobseekerapprenticeship.spring_api_test.entity.UserType;
import com.jobseekerapprenticeship.spring_api_test.entity.Vacancy;
import com.jobseekerapprenticeship.spring_api_test.repository.UserRepository;
import com.jobseekerapprenticeship.spring_api_test.repository.VacancyRepository;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._constant.ApiEndpointUri;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request.DeleteVacancyRequest;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request.PostVacancyRequest;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request.PutVacancyRequest;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ApiEndpointUri.vacancy)
@RestController
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyRepository repository;
    private final UserRepository userRepository;
    private final ITimeProvider timeProvider;

    @PostMapping("")
    @PreAuthorize("hasAuthority('" + UserType.AuthorityName.ADMIN + "')")
    public ResponseEntity<?> createNewVacancy(
        @Valid @RequestBody PostVacancyRequest request
    ){
        final Vacancy newVacancy = repository.insert(new Vacancy(
            request.vacancyName(),
            request.description(),
            request.maxAge(),
            request.minimumYearsExperience(),
            request.salary(),
            timeProvider
        ));

        return new VacancyCreatedResponse(newVacancy).toHttpResponse();
    }

    @PreAuthorize("hasAnyAuthority('" + UserType.AuthorityName.ADMIN + "')")
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
            oldVacancy.setExpiryDate(
                Vacancy.vacancyExpirationDurationMillis + timeProvider.getCurrentTimeMillis()
            );

        final Vacancy newVacancy = repository.save(oldVacancy);

        return new VacancyUpdatedResponse(newVacancy).toHttpResponse();
    }

    @PreAuthorize("hasAnyAuthority('" + UserType.AuthorityName.ADMIN + "')")
    @DeleteMapping("")
    public ResponseEntity<?> deleteVacancy(
        @Valid @RequestBody DeleteVacancyRequest request
    ){
        final Vacancy deletedVacancy = repository.findById(new ObjectId(request.vacancyId())).orElse(null);
        if (deletedVacancy == null)
            return new VacancyWithIdNotFound().toHttpResponse();

        repository.deleteById(new ObjectId(deletedVacancy.getId()));
        return new VacancyDeletedResponse(deletedVacancy).toHttpResponse();
    }

    @GetMapping("")
    public ResponseEntity<?> getVacancies(
        Authentication auth
    ){
        final UserDetails currentUserDetails = (UserDetails) auth.getPrincipal();
        final boolean currentUserIsAdmin = currentUserDetails
                .getAuthorities()
                .contains(new SimpleGrantedAuthority(UserType.ADMIN.authorityName));

        final List<Vacancy> listVacancies;

        if (currentUserIsAdmin) {
            listVacancies = repository.findAll();
        }
        else {
            listVacancies = repository.findByNotExpired(timeProvider.getCurrentTimeMillis());
        }

        return new GetVacanciesResponse(listVacancies).toHttpResponse();
    }
}
