package com.example.ejemplojpa.model;

import lombok.Data;

@Data
public class UserRoleModel {

    private String role;
    private int userRoleId;

    public UserRoleModel() {

    }

    public UserRoleModel(String role, int userRoleId) {

        this.role = role;
        this.userRoleId = userRoleId;
    }

}
