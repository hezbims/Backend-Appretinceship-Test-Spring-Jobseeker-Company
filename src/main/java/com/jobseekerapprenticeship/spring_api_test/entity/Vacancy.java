package com.jobseekerapprenticeship.spring_api_test.entity;

import com.jobseekerapprenticeship.spring_api_test.configuration.timeProvider.ITimeProvider;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
@Accessors(chain = true)
public class Vacancy {
    @Id
    private String id;
    private String vacancyName;
    private String description;
    private Integer maximumAge;
    private int minimumYearsExperience;
    private Integer salary;
    private long publishedDate;
    private long expiryDate;

    public static final long vacancyExpirationDurationMillis = 1000L * 3600 * 24 * 30;

    /**
     * @param vacancyName Judul lamaran
     * @param description Deskripsi lamaran
     * @param maximumAge Umur maksimal
     * @param minimumYearsExperience Minimal tahun pengalaman
     * @param salary Gaji
     */
    public Vacancy(
        String vacancyName,
        String description,
        Integer maximumAge,
        Integer minimumYearsExperience,
        Integer salary,
        ITimeProvider timeProvider
    ){
        this.vacancyName = vacancyName;
        this.description = description;
        this.maximumAge = maximumAge;
        this.minimumYearsExperience = minimumYearsExperience == null ? 0 : minimumYearsExperience;
        this.salary = salary;

        final long publishedDate = timeProvider.getCurrentTimeMillis();
        this.publishedDate = publishedDate;
        this.expiryDate = publishedDate + vacancyExpirationDurationMillis;
    }

    public Vacancy setMinimumYearsExperience(Integer minimumYearsExperience) {
        this.minimumYearsExperience = minimumYearsExperience == null ? 0 : minimumYearsExperience;
        return this;
    }

}
