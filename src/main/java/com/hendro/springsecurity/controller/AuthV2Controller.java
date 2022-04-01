package com.hendro.springsecurity.controller;

import com.hendro.springsecurity.payload.TokenResponse;
import com.hendro.springsecurity.payload.UsernamePassword;
import com.hendro.springsecurity.service.AuthService;
import com.hendro.springsecurity.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/auth")
@RequiredArgsConstructor
public class AuthV2Controller {

    private final AuthService authService;

    @PostMapping(value="/register")
    public ResponseEntity<?> register(@RequestBody UsernamePassword req) {
        authService.register(req);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value="/login")
    public ResponseEntity<?> login(@RequestBody UsernamePassword req) {
        TokenResponse token = authService.generateToken(req);
        return ResponseUtil.build(token, HttpStatus.OK);
    }

    @GetMapping(value="/info")
    public ResponseEntity<Object> getInfo(@RequestHeader("Authorization") String req)  {

        return authService.getInfo(req);
    }

    @GetMapping("/tes")
    public ResponseEntity<?> getHello(){
        return ResponseEntity.ok("Hello world");
    }
}
