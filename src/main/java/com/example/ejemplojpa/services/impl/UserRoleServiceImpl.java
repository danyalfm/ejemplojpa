package com.example.ejemplojpa.services.impl;

import com.example.ejemplojpa.components.UserRoleConverter;
import com.example.ejemplojpa.entity.UserRole;
import com.example.ejemplojpa.model.UserRoleModel;
import com.example.ejemplojpa.repository.UserRoleRepository;
import com.example.ejemplojpa.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userRoleServiceImpl")
public class UserRoleServiceImpl implements UserRoleService {

        @Autowired
        @Qualifier("userRoleRepository")
        private UserRoleRepository userRoleRepository;

        @Autowired
        @Qualifier("userRoleConverter")
        private UserRoleConverter userRoleConverter;

        @Override
        public UserRoleModel addUserRole (UserRoleModel userRoleModel){
        //Aquí nos pide una entidad, por lo tanto tenemos que transformar el contactModel a entidad
        UserRole temp = userRoleConverter.convertToUserRoleModel2UserRole(userRoleModel);
        UserRole userRole = userRoleRepository.save(temp);
        return userRoleConverter.convertUserRole2UserRoleModel(userRole);
    }

        @Override
        public List<UserRoleModel> listAllUserRoles () {
        List<UserRole> userRoles = userRoleRepository.findAll();
        List<UserRoleModel> userRolesModel = new ArrayList();
        for (UserRole userRole : userRoles) {
            userRolesModel.add(userRoleConverter.convertUserRole2UserRoleModel(userRole));

        }
        return userRolesModel;
    }

        @Override
        public UserRole findUserRoleById (int userRoleId){
        return userRoleRepository.findById(userRoleId);
    }

        public UserRoleModel findUserRoleByIdModel (int userRoleId){
        return userRoleConverter.convertUserRole2UserRoleModel(findUserRoleById(userRoleId));
    }

        @Override
        public void removeUserRole (int userRoleId){
        UserRole userRole = findUserRoleById(userRoleId);
        if (userRole != null) {
            userRoleRepository.delete(findUserRoleById(userRoleId));
        }

    }

}
