package com.hendro.springsecurity.service.impl;

import com.hendro.springsecurity.model.User;
import com.hendro.springsecurity.repository.UserRepository;
import com.hendro.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getDistinctTopByPhone(username);
        if(user == null)
            throw new UsernameNotFoundException("Username not found");

        return user;
    }



}
