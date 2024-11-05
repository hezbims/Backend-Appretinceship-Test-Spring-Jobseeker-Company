package com.jobseekerapprenticeship.spring_api_test.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Vacancy {
    private ObjectId id;
    private String vacancyName;
    private String description;
    private Integer maximumAge;
    private int minimumYearsExperience;
    private Integer salary;
    private long publishedDate;
    private long expiryDate;

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
        int minimumYearsExperience,
        Integer salary
    ){
        this.vacancyName = vacancyName;
        this.description = description;
        this.maximumAge = maximumAge;
        this.minimumYearsExperience = minimumYearsExperience;
        this.salary = salary;

        final long publishedDate = System.currentTimeMillis();
        this.publishedDate = publishedDate;
        this.expiryDate = publishedDate + (1000L * 3600 * 24 * 30);
    }
}
