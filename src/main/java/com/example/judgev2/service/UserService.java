package com.example.judgev2.service;

import com.example.judgev2.model.entity.User;
import com.example.judgev2.model.service.UserServiceModel;
import com.example.judgev2.model.view.UserProfileViewModel;

import java.util.List;

public interface UserService {

    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findUserByUsernameAndPassword(String username, String password);

    void login(UserServiceModel userServiceModel);

    void logoutUser();

    List<String> findAllUsernames();

    void changeRole(String username, String role);

    User findByUsername(String username);

    UserProfileViewModel findById(Long id);
}
