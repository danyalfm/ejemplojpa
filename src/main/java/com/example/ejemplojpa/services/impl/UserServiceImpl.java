package com.example.ejemplojpa.services.impl;

import com.example.ejemplojpa.components.UserConverter;
import com.example.ejemplojpa.entity.User;
import com.example.ejemplojpa.model.UserModel;
import com.example.ejemplojpa.repository.UserRepository;
import com.example.ejemplojpa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Autowired
    @Qualifier("userConverter")
    private UserConverter userConverter;

    @Override
    public UserModel addUser(UserModel userModel) {
        //Aquí nos pide una entidad, por lo tanto tenemos que transformar el contactModel a entidad
        User temp = userConverter.convertToUserModel2User(userModel);
        User user = userRepository.save(temp);
        return userConverter.convertUser2UserModel(user);
    }

    @Override
    public List<UserModel> listAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserModel> usersModel = new ArrayList();
        for (User user : users) {
            usersModel.add(userConverter.convertUser2UserModel(user));

        }
        return usersModel;
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserModel findUserByUsernameModel(String username) {
        return userConverter.convertUser2UserModel(findUserByUsername(username));
    }

    @Override
    public void removeUser(String username) {
        User user = findUserByUsername(username);
        if (user != null) {
            userRepository.delete(findUserByUsername(username));
        }
    }


}
