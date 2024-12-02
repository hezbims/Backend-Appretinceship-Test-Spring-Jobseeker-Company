package com.jobseekerapprenticeship.spring_api_test.rest_controller._response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.Data;

/**
 * Digunakan untuk memformat response dari REST API agar konsisten
 * @param <T> tipe dari data yang disimpan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyApiRestResult<T> {
    private String message;
    private String type;

    @JsonIgnore
    private HttpStatus status;

    @JsonProperty("status")
    public int getStatusCode(){
        return status.value();
    }

    @JsonProperty("status")
    public void setStatus(int status){
        this.status = HttpStatus.valueOf(status);
    }

    private T data;

    public ResponseEntity<Object> toHttpResponse(){
        return new ResponseEntity<>(this, status);
    }

    public MyApiRestResult(
        String message,
        String type,
        HttpStatus status
    ){
        this.message = message;
        this.type = type;
        this.status = status;
    }
}
