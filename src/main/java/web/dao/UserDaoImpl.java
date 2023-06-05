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


    private SessionFactory sessionFactory;

    private User user;

//    private List<User> usersList;

//    private static Long count = 0L;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUserInUserList(String name, String lastName, String email) {
        sessionFactory.getCurrentSession().save(new User(name,lastName, email));
    }


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

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User getUserByID(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void deleteUserByID(Long id) {
        sessionFactory.getCurrentSession().delete(user.getId());
    }
}
