package com.jobseekerapprenticeship.spring_api_test.rest_controller._response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * Digunakan untuk memformat response dari REST API agar konsisten
 * @param <T> tipe dari data yang disimpan
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class MyApiRestResult<T> {
    private final String message;
    private final String type;

    @JsonIgnore
    private final HttpStatus status;

    private T data;

    public ResponseEntity<Object> toHttpResponse(){
        return new ResponseEntity<>(this, status);
    }
}
