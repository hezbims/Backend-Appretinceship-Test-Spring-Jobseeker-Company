package com.jobseekerapprenticeship.spring_api_test.repository;

import com.jobseekerapprenticeship.spring_api_test.entity.User;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByEmail(String email);
}
