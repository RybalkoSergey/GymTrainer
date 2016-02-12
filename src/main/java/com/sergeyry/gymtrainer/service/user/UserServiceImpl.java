package com.sergeyry.gymtrainer.service.user;

import com.sergeyry.gymtrainer.dao.user.UserDao;
import com.sergeyry.gymtrainer.model.user.User;
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

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        User entity = userDao.findById(user.getId());
        if(entity!=null){
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
        }
    }

    public void deleteByLogin(String login) {
        userDao.deleteByLogin(login);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }

    public boolean isUserLoginUnique(String login) {
        User user = findByLogin(login);
        return user == null;
    }
}
