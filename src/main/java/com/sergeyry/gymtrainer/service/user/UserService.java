package com.sergeyry.gymtrainer.service.user;

import com.sergeyry.gymtrainer.model.user.User;

import java.util.List;


public interface UserService {

    User findById(int id);

    void save(User user);

    void update(User user);

    void deleteByLogin(String login);

    List<User> findAll();

    User findByLogin(String login);

    boolean isUserLoginUnique(String login);
}
