package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    private List<User> usersList = new ArrayList<>();
    private static Long count = 0L;

//    {
//        usersList.add(new User(++count, "Tom", "Jones", "TJ@mail.dj"));
//        usersList.add(new User(++count, "Rom", "Tos", "RT@mail.dj"));
//        usersList.add(new User(++count, "Weom", "Poos", "WP@mail.dj"));
//        usersList.add(new User(++count, "Weom1", "Poos1", "WP1@mail.dj"));
//        usersList.add(new User(++count, "Weom2", "Poos2", "WP2@mail.dj"));
//
//    }
    @Override
    public void addUserInUserList(String name, String surName, String email) {
        usersList.add(new User(++count, "Name","SurName", "email@mail.dj"));
    }

//    public List<User> getUsersList() {
//        return usersList;
//    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getUsersList() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
