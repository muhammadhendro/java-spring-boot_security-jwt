package com.hendro.springsecurity.util;

import com.hendro.springsecurity.model.base.BaseResponse;
import com.hendro.springsecurity.payload.TokenResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ResponseUtil {

    private ResponseUtil(){}


    private static BaseResponse build( Object data) {
        return BaseResponse.builder()
                .data(data)
                .build();
    }

    public static ResponseEntity<Object> build(TokenResponse token, HttpStatus httpStatus) {
        return new ResponseEntity<>(build(token), httpStatus);

    }
}