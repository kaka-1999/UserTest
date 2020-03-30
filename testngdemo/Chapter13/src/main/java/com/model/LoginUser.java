package com.model;

import lombok.Data;

@Data
public class LoginUser {
    private int id;
    private String username;
    private String password;
    private String expected;
}
