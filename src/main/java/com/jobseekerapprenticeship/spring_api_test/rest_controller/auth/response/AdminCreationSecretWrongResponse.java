package com.jobseekerapprenticeship.spring_api_test.rest_controller.auth.response;

import com.jobseekerapprenticeship.spring_api_test.rest_controller._response.MyApiRestResult;

import org.springframework.http.HttpStatus;

public class AdminCreationSecretWrongResponse extends MyApiRestResult<Object> {
    public AdminCreationSecretWrongResponse(){
        super(
            "Kode untuk pembuatan akun admin salah!",
            "AdminCreationSecretWrong",
            HttpStatus.BAD_REQUEST
        );
    }
}
