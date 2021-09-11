package com.oracle.po;


import lombok.Data;

@Data
public class User {
    private String username;
    private String password;

    public User(String asd, String asd1) {
        this.username=asd;
        this.password=asd1;
    }
}
