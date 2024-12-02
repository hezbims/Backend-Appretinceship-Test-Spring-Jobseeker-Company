package com.jobseekerapprenticeship.spring_api_test.testConfig;

import com.jobseekerapprenticeship.spring_api_test.configuration.timeProvider.ITimeProvider;
import com.jobseekerapprenticeship.spring_api_test.entity.User;
import com.jobseekerapprenticeship.spring_api_test.repository.UserRepository;
import com.jobseekerapprenticeship.spring_api_test.repository.VacancyRepository;
import com.jobseekerapprenticeship.spring_api_test.seeder.UserTestSeeder;
import com.jobseekerapprenticeship.spring_api_test.seeder.VacancyTestSeeder;
import com.jobseekerapprenticeship.spring_api_test.services.auth.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

@TestConfiguration
public class TestBeanConfig {
    @Bean
    public UserTestSeeder userTestSeeder(UserRepository repository){
        return new UserTestSeeder(repository);
    }

    @Bean
    public VacancyTestSeeder vacancyTestSeeder(
        VacancyRepository repository,
        TestTimeProvider testTimeProvider
    ){
        return new VacancyTestSeeder(repository, testTimeProvider);
    }

    @Bean
    public ITimeProvider timeProvider(){
        return new TestTimeProvider();
    }

    @Bean
    public TestTimeProvider testTimeProvider(ITimeProvider timeProvider){
        return (TestTimeProvider) timeProvider;
    }

    @Lazy
    @Bean
    public TestRestTemplate adminTestRestTemplate(
        UserRepository repository,
        UserTestSeeder userTestSeeder,
        RestTemplateBuilder restTemplateBuilder,
        JwtService jwtService,
        @Value("${local.server.port}") int port
    ){
        return generateTestRestTemplateByUserEmail(
                "admin@gmail.com",
                repository,
                userTestSeeder,
                restTemplateBuilder,
                jwtService,
                port);
    }

    @Lazy
    @Bean
    public TestRestTemplate nonAdminTestRestTemplate(
        UserRepository repository,
        UserTestSeeder userTestSeeder,
        RestTemplateBuilder restTemplateBuilder,
        JwtService jwtService,
        @Value("${local.server.port}") int port
    ){
        return generateTestRestTemplateByUserEmail(
                "non-admin@gmail.com",
                repository,
                userTestSeeder,
                restTemplateBuilder,
                jwtService,
                port);
    }

    private TestRestTemplate generateTestRestTemplateByUserEmail(
        String email,
        UserRepository repository,
        UserTestSeeder userTestSeeder,
        RestTemplateBuilder restTemplateBuilder,
        JwtService jwtService,
        int port
    ){
        if (repository.count() == 0)
            userTestSeeder.execute();

        User admin = repository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException(
                "Email '" + email + "' tidak ditemukan!"));

        return new TestRestTemplate(
    restTemplateBuilder
            .defaultHeader(
        "Authorization",
        "Bearer " + jwtService.generateJwt(admin.getEmail())
            )
            .rootUri("http://localhost:" + port)
        );
    }
}
