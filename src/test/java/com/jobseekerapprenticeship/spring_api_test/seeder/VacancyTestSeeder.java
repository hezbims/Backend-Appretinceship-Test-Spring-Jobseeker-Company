package com.jobseekerapprenticeship.spring_api_test.seeder;

import com.jobseekerapprenticeship.spring_api_test.entity.Vacancy;
import com.jobseekerapprenticeship.spring_api_test.repository.VacancyRepository;
import com.jobseekerapprenticeship.spring_api_test.testConfig.TestTimeProvider;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
public class VacancyTestSeeder {
    private final VacancyRepository repository;
    private final TestTimeProvider timeProvider;

    public void execute(){
        repository.insert(Arrays.asList(
            new Vacancy()
                .setVacancyName("vacancy-1")
                .setDescription("ini adalah deskripsi 1")
                .setMaximumAge(35)
                .setMinimumYearsExperience(9)
                .setSalary(10_000_000)
                .setPublishedDate(timeProvider.getCurrentTimeMillis())
                .setExpiryDate(timeProvider.getCurrentTimeMillis() + Vacancy.vacancyExpirationDurationMillis),
            new Vacancy()
                .setVacancyName("vacancy-2")
                .setDescription("ini deskripsi yang kedua")
                .setMaximumAge(25)
                .setMinimumYearsExperience(2)
                .setSalary(4_500_000)
                .setPublishedDate(timeProvider.getTimeInMillisBasedOnDayForward(-13))
                .setExpiryDate(timeProvider.getTimeInMillisBasedOnDayForward(-6)),
            new Vacancy()
                .setVacancyName("vacancy-3")
                .setDescription("ini deskripsi yang ketiga")
                .setMaximumAge(25)
                .setMinimumYearsExperience(2)
                .setSalary(4_500_000)
                .setPublishedDate(timeProvider.getTimeInMillisBasedOnDayForward(-10))
                .setExpiryDate(timeProvider.getTimeInMillisBasedOnDayForward(-2))
        ));
    }

    public void cleanAllVacancies(){
        repository.deleteAll();
    }
}
