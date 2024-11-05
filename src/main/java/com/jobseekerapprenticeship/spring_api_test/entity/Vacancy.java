package com.jobseekerapprenticeship.spring_api_test.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Vacancy {
    public String vacancyName;
    public String description;
    public int maximumAge;
    public int minimumYearsExperience;
    public int salary;
    public long publishedDate;
    public long expiryDate;
}
