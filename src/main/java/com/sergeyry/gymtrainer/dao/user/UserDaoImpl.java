package com.sergeyry.gymtrainer.dao.user;

import com.sergeyry.gymtrainer.dao.AbstractDao;
import com.sergeyry.gymtrainer.model.user.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    public User findById(int id) {
        return getByKey(id);
    }

    public void save(User user) {
        persist(user);
    }

    public void deleteByLogin(String login) {
        Query query = getSession().createSQLQuery("delete from USERS where LOGIN = :login");
        query.setString("login", login);
        query.executeUpdate();
    }

    public List<User> findAll() {
        Criteria criteria = createEntityCriteria();
        return (List<User>) criteria.list();
    }

    public User findByLogin(String login) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("login", login));
        return (User) criteria.uniqueResult();
    }
}
