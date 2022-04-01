package com.hendro.springsecurity.payload;

import lombok.Data;

@Data
public class UsernamePassword {
    private String username;
    private String phone;
    private String password;
}
