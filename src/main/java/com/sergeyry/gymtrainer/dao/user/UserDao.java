package com.sergeyry.gymtrainer.dao.user;

import com.sergeyry.gymtrainer.model.program.Program;
import com.sergeyry.gymtrainer.model.user.User;

import java.util.List;


public interface UserDao {
    User findById(int id);

    void save(User user);

    void deleteByLogin(String login);

    List<User> findAll();

    User findByLogin(String login);

    void deleteById(int id);
}
