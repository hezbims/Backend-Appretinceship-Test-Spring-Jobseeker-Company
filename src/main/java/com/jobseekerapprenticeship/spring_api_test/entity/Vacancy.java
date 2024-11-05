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
    private int maximumAge;
    private int minimumYearsExperience;
    private int salary;
    private long publishedDate;
    private long expiryDate;
}
