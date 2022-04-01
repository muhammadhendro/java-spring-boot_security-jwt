package com.hendro.springsecurity.controller;

import com.hendro.springsecurity.payload.TokenResponse;
import com.hendro.springsecurity.payload.UsernamePassword;
import com.hendro.springsecurity.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping(value="/register")
    public ResponseEntity<?> register(@RequestBody UsernamePassword req) {
        authService.register(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value="/token")
    public ResponseEntity<?> generateToken(@RequestBody UsernamePassword req) {
        TokenResponse token = authService.generateToken(req);
        return ResponseEntity.ok(token);
    }
}
