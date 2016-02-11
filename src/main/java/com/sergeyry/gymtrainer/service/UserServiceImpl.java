package com.sergeyry.gymtrainer.service;

import com.sergeyry.gymtrainer.dao.UserDao;
import com.sergeyry.gymtrainer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User findById(int id) {
        return userDao.findById(id);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    public void updateUser(User user) {
        User entity = userDao.findById(user.getId());
        if(entity!=null){
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
        }
    }

    public void deleteUserByLogin(String login) {
        userDao.deleteUserByLogin(login);
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    public User findUserByLogin(String login) {
        return userDao.findUserByLogin(login);
    }

    public boolean isUserLoginUnique(String login) {
        User user = findUserByLogin(login);
        return user == null;
    }
}
