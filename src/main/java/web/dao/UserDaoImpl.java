package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.TypedQuery;
import java.util.List;

@Component
//@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
        logger.info("UsersList получен");
        return query.getResultList();
    }

    @Override
    public void add(User user) {
//        sessionFactory.getCurrentSession().save(user);
        sessionFactory.getCurrentSession().persist(user);
        logger.info("Добавлен User " + user);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
        logger.info("Информация о Userе " + user + " изменена");
    }

    @Override
    public User getUserByID(Long id) {
//        return sessionFactory.getCurrentSession().get(User.class, id);
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        logger.info("User " + user + " загружен");
        return user;
    }

    @Override
    public void deleteUserByID(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        if (user != null) {
            session.delete(user);
            logger.info("User " + user + " удален");
        }
        logger.info("User " + user + " не удален");
    }
}
