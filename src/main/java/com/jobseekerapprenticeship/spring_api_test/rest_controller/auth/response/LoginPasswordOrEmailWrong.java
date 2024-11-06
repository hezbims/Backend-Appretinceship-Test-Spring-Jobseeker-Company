package com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.response;

import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

public class LoginPasswordOrEmailWrong extends MyApiRestResult<Object> {
    public LoginPasswordOrEmailWrong(){
        super(
            "Password atau email salah",
            "LoginPasswordOrEmailWrong",
                HttpStatus.FORBIDDEN
        );
    }
}
