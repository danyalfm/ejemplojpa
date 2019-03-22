package com.example.ejemplojpa.components;

import com.example.ejemplojpa.entity.User;
import com.example.ejemplojpa.model.UserModel;
import org.springframework.stereotype.Component;

@Component("userConverter")
public class UserConverter {

    public User convertToUserModel2User(UserModel userModel) {
        User user = new User();
        user.setEnabled(userModel.isEnabled());
        user.setPassword(userModel.getPassword());
        user.setUsername(userModel.getUsername());
        return user;
    }

    public UserModel convertUser2UserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setEnabled(user.isEnabled());
        userModel.setPassword(user.getPassword());
        userModel.setUsername(user.getUsername());
        return userModel;
    }
}

