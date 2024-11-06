package com.jobseekerapprenticeship.spring_api_test.configuration;

import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

import java.util.List;

public class InvalidFieldError extends MyApiRestResult<Object> {
    public InvalidFieldError(List<MySimpleFieldError> erros){
        super(
            "Ada field yang tidak valid",
            "InvalidField",
                HttpStatus.BAD_REQUEST,
                erros
        );
    }
}
