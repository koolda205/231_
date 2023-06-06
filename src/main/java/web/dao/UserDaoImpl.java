package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    @Override
//    public void addUserInUserList(String name, String lastName, String email) {
//        sessionFactory.getCurrentSession().save(new User(name,lastName, email));
//    }
//
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public List<User> getUsersList() {
//        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
//        return query.getResultList();
//    }
//
//    @Override
//    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
//    }
//
//    @Override
//    public void update(User user) {
//        sessionFactory.getCurrentSession().update(user);
//    }
//
//    @Override
//    public User getUserByID(Long id) {
//        return sessionFactory.getCurrentSession().get(User.class, id);
//    }
//
//    @Override
//    public void deleteUserByID(Long id) {
//        sessionFactory.getCurrentSession().delete(user.getId());
//    }
    @Override
    @Transactional
    public List<User> getAllUsers() {

        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers= session.createQuery("from User", User.class)
            .getResultList();
        return allUsers;
    }
}
