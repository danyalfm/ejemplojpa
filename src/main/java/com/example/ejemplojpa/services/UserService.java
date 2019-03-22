package com.example.ejemplojpa.services;

import com.example.ejemplojpa.entity.User;
import com.example.ejemplojpa.model.UserModel;

import java.util.List;

public interface UserService {
    public abstract UserModel addUser(UserModel userModel);

    public abstract List<UserModel> listAllUsers();

    public abstract User findUserByUsername(String username);

    public abstract void removeUser(String username);

    public abstract UserModel findUserByUsernameModel(String username);

}
