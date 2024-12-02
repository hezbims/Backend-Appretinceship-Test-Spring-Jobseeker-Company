package com.jobseekerapprenticeship.spring_api_test.scenario.vacancy;

import com.jobseekerapprenticeship.spring_api_test.repository.UserRepository;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._constant.ApiEndpointUri;
import com.jobseekerapprenticeship.spring_api_test.rest_controller.vacancy.response.GetVacanciesResponse;
import com.jobseekerapprenticeship.spring_api_test.seeder.VacancyTestSeeder;
import com.jobseekerapprenticeship.spring_api_test.testConfig.containers.BaseIntegrationTestContainer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class GetVacancyTest extends BaseIntegrationTestContainer {

    @Autowired
    @Qualifier("adminTestRestTemplate")
    private TestRestTemplate adminRestTemplate;

    @Autowired
    @Qualifier("nonAdminTestRestTemplate")
    private TestRestTemplate nonAdminRestTemplate;

    @Autowired
    private VacancyTestSeeder vacancyTestSeeder;

    @Autowired
    private UserRepository userRepo;

    @BeforeEach
    public  void beforeEach(){
        vacancyTestSeeder.execute();
    }

    @AfterEach
    public void afterEach(){
        vacancyTestSeeder.cleanAllVacancies();
    }

    @Test
    public void adminShouldSeeAllVacancies() {
        var response =
            adminRestTemplate.getForObject(ApiEndpointUri.vacancy, GetVacanciesResponse.class);
        assertThat(response.getData().size()).isEqualTo(3);
    }

    @Test
    public void nonAdminShouldSeeOnlyNonExpiredVacancies() {
        var response =
                nonAdminRestTemplate.getForObject(ApiEndpointUri.vacancy, GetVacanciesResponse.class);
        assertThat(response.getData().size()).isEqualTo(1);
    }
}
