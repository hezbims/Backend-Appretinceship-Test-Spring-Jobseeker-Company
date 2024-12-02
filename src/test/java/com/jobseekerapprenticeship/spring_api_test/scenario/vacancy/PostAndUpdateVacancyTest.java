package com.jobseekerapprenticeship.spring_api_test.scenario.vacancy;

import com.jobseekerapprenticeship.spring_api_test.repository.VacancyRepository;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._constant.ApiEndpointUri;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.request.PostVacancyRequest;
import com.jobseekerapprenticeship.spring_api_test.testConfig.containers.BaseIntegrationTestContainer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class PostAndUpdateVacancyTest extends BaseIntegrationTestContainer {
    @Autowired
    @Qualifier("adminTestRestTemplate")
    private TestRestTemplate adminRestTemplate;

    @Autowired
    @Qualifier("nonAdminTestRestTemplate")
    private TestRestTemplate nonAdminRestTemplate;

    @Autowired
    private VacancyRepository vacancyRepository;

    @Test
    public void nonAdminCanNotPostNewVacancy(){
        PostVacancyRequest requestBody = new PostVacancyRequest(
            "ini adalah vacancy baru",
                "ini adalah deskripsinya",
                25,
                2,
                2_500_000
        );
        ResponseEntity<String> response = nonAdminRestTemplate
            .postForEntity(
                ApiEndpointUri.vacancy,
                    requestBody,
                    String.class
            );

        assertThat(response.getStatusCode().value())
                .isEqualTo(HttpStatus.FORBIDDEN.value());
        assertThat(vacancyRepository.count()).isEqualTo(0);
    }

    @Test
    public void adminCanPostNewVacancy(){
        PostVacancyRequest requestBody = new PostVacancyRequest(
                "ini adalah vacancy baru",
                "ini adalah deskripsinya",
                25,
                2,
                2_500_000
        );
        ResponseEntity<String> response = adminRestTemplate
                .postForEntity(
                        ApiEndpointUri.vacancy,
                        requestBody,
                        String.class
                );

        assertThat(response.getStatusCode().value())
                .isEqualTo(HttpStatus.CREATED.value());
        assertThat(vacancyRepository.count()).isEqualTo(1);

        vacancyRepository.deleteAll();
    }
}
