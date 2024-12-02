package com.jobseekerapprenticeship.spring_api_test.testConfig.containers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class BaseMongoTestContainer {
    @ServiceConnection
    private static final MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:8.0.3")
            .withExposedPorts(27017)
            .withReuse(true);

    @BeforeAll
    public static void beforeAll(){
        mongoDBContainer.start();
    }

    protected ObjectMapper objectMapper = new ObjectMapper();
}
