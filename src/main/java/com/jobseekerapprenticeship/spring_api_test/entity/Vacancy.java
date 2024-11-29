package com.jobseekerapprenticeship.spring_api_test.entity;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
@Builder
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
        Integer salary
    ){
        this.vacancyName = vacancyName;
        this.description = description;
        this.maximumAge = maximumAge;
        this.minimumYearsExperience = minimumYearsExperience == null ? 0 : minimumYearsExperience;
        this.salary = salary;

        final long publishedDate = System.currentTimeMillis();
        this.publishedDate = publishedDate;
        this.expiryDate = publishedDate + vacancyExpirationDurationMillis;
    }

    public void setMinimumYearsExperience(Integer minimumYearsExperience) {
        this.minimumYearsExperience = minimumYearsExperience == null ? 0 : minimumYearsExperience;
    }
}
