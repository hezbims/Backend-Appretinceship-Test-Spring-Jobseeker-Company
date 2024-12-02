package com.jobseekerapprenticeship.spring_api_test.testConfig.containers;

import com.jobseekerapprenticeship.spring_api_test.testConfig.TestBeanConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = {"spring.main.allow-bean-definition-overriding=true"}
)
@Import(TestBeanConfig.class)
public class BaseIntegrationTestContainer extends BaseMongoTestContainer {
}
