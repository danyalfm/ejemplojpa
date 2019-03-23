package com.example.ejemplojpa.model;

import lombok.Data;

@Data
public class UserModel {
    private String username;
    private String password;
    private boolean enabled;


    public UserModel() {

    }

    public UserModel(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

}
