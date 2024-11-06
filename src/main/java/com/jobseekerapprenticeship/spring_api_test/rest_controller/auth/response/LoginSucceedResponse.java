package com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.response;

import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

public class LoginSucceedResponse extends MyApiRestResult<UserWithTokenModel> {
    public LoginSucceedResponse(String email, String token){
        super(
                "Login berhasil",
                "LoginSucceed",
                HttpStatus.ACCEPTED,
                new UserWithTokenModel(email, token)
        );
    }
}
