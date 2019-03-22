package com.example.ejemplojpa.services;


import com.example.ejemplojpa.entity.UserRole;
import com.example.ejemplojpa.model.UserRoleModel;

import java.util.List;

public interface UserRoleService {
    public abstract UserRoleModel addUserRole(UserRoleModel userRoleModel);

    public abstract List<UserRoleModel> listAllUserRoles();

    public abstract UserRole findUserRoleById(int userRoleId);

    public abstract void removeUserRole(int userRoleId);

    public abstract UserRoleModel findUserRoleByIdModel(int userRoleId);

}
