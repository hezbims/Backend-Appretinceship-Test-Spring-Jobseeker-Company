package com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.response;

import com.jobseekerapprenticeship.spring_api_test.entity.User;
import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

public class UserRegisteredResponse extends MyApiRestResult {
    public UserRegisteredResponse(User user){
        super(
            "Berhasil mendaftarkan user baru",
            "UserRegisteredSuccessfully",
                HttpStatus.CREATED,
                user
        );
    }
}
