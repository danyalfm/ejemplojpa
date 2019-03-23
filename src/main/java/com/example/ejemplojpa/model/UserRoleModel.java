package com.example.ejemplojpa.model;

import com.example.ejemplojpa.entity.User;
import lombok.Data;

@Data
public class UserRoleModel {

    private String role;
    private int userRoleId;
    private User user;

    public UserRoleModel() {

    }

    public UserRoleModel(String role, int userRoleId, User user) {

        this.role = role;
        this.userRoleId = userRoleId;
        this.user = user;
    }

}
