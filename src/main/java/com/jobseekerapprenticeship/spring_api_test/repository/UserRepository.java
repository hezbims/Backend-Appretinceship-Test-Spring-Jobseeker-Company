package com.jobseekerapprenticeship.spring_api_test.repository;

import com.jobseekerapprenticeship.spring_api_test.entity.User;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> { }
