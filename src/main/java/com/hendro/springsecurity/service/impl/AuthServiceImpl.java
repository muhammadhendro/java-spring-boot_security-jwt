package com.hendro.springsecurity.service.impl;

import com.hendro.springsecurity.model.User;
import com.hendro.springsecurity.payload.TokenResponse;
import com.hendro.springsecurity.payload.UsernamePassword;
import com.hendro.springsecurity.repository.UserRepository;
import com.hendro.springsecurity.security.JwtTokenProvider;
import com.hendro.springsecurity.service.AuthService;
import com.hendro.springsecurity.util.ResponseUtil;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Base64;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User register(UsernamePassword req) {
       User user = new User();
       user.setUsername(req.getUsername());
        user.setPhone(req.getPhone());
       user.setPassword(passwordEncoder.encode(req.getPassword()));
       return userRepository.save(user);
    }



    @Override
    public TokenResponse generateToken(UsernamePassword req) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            req.getPhone(),
                            req.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenProvider.generateToken(authentication);
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setToken(jwt);
            return tokenResponse;

        } catch (BadCredentialsException e) {

            log.error("Bad credential", e);
            throw new RuntimeException(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);

        }
    }

    @Override
    public ResponseEntity<Object> getInfo(TokenResponse req) {
        return ResponseEntity.ok("a");
    }

    @Override
    public ResponseEntity<Object> getInfo(String req) {
//        byte[] decodedBytes = Base64.getDecoder().decode(req);
//        System.out.println(new String(decodedBytes));

        return ResponseEntity.ok("OK");
//        return ResponseUtil.build(null, HttpStatus.OK);
    }


}
