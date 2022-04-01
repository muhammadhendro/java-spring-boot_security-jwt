package com.hendro.springsecurity.service;


import com.hendro.springsecurity.model.User;
import com.hendro.springsecurity.payload.TokenResponse;
import com.hendro.springsecurity.payload.UsernamePassword;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    User register(UsernamePassword req);

    TokenResponse generateToken(UsernamePassword req);




    ResponseEntity<Object> getInfo(TokenResponse req);

    ResponseEntity<Object> getInfo(String req);
}
