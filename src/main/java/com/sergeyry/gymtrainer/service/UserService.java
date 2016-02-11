package com.sergeyry.gymtrainer.service;

import com.sergeyry.gymtrainer.model.User;

import java.util.List;


public interface UserService {

    User findById(int id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserByLogin(String login);

    List<User> findAllUsers();

    User findUserByLogin(String login);

    boolean isUserLoginUnique(String login);
}
