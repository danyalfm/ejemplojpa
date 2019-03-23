package com.example.ejemplojpa.components;


import com.example.ejemplojpa.entity.UserRole;
import com.example.ejemplojpa.model.UserRoleModel;
import org.springframework.stereotype.Component;

@Component("userRoleConverter")
public class UserRoleConverter {

    public UserRole convertToUserRoleModel2UserRole(UserRoleModel userRoleModel) {
        UserRole userRole = new UserRole();
        userRole.setRole(userRoleModel.getRole());
        userRole.setUserRoleId(userRoleModel.getUserRoleId());
        userRole.setUser(userRoleModel.getUser());
        return userRole;
    }

    public UserRoleModel convertUserRole2UserRoleModel(UserRole userRole) {
        UserRoleModel userRoleModel = new UserRoleModel();
        userRoleModel.setRole(userRole.getRole());
        userRoleModel.setUserRoleId(userRole.getUserRoleId());
        userRoleModel.setUser(userRole.getUser());
        return userRoleModel;
    }
}
