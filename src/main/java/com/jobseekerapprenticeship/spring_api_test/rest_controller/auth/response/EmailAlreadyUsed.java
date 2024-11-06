package com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.response;

import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

public class EmailAlreadyUsed extends MyApiRestResult<Object> {
    public EmailAlreadyUsed(){
        super(
                "Email sudah digunakan",
                "EmailAlreadyUsed",
                HttpStatus.FORBIDDEN
        );
    }
}
