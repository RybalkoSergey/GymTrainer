package com.sergeyry.gymtrainer.dao;

import com.sergeyry.gymtrainer.model.user.User;

import java.util.List;


public interface UserDao {
    User findById(int id);

    void saveUser(User user);

    void deleteUserByLogin(String login);

    List<User> findAllUsers();

    User findUserByLogin(String login);
}
