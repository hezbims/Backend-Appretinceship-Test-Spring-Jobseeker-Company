package com.jobseekerapprenticeship.spring_api_test.repository;

import com.jobseekerapprenticeship.spring_api_test.entity.Vacancy;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface VacancyRepository extends MongoRepository<Vacancy, ObjectId> {
    @Query("{'expiryDate': {$gt : ?0}}")
    public List<Vacancy> findByNotExpired(Long currentTimeMillis);
}
