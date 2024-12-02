package com.jobseekerapprenticeship.spring_api_test.configuration.timeProvider;

import org.springframework.stereotype.Service;

@Service("timeProvider")
public class TimeProvider implements ITimeProvider {
    @Override
    public Long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
