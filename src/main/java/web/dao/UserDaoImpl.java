package web.dao;

import org.springframework.stereotype.Repository;

import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    public List<User> getAllUsers() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser (User user) {

       entityManager.persist(user);
    }

    @Override
    public User getUserByID(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void deleteUserByID(Long id) {

        User user = entityManager.find(User.class, id);
        entityManager.remove (user);
    }

    @Override
    public void editUserByID(Long id) {

        User user = entityManager.find(User.class, id);
        entityManager.merge (user);
    }
}

//    private SessionFactory sessionFactory;
//
//    @Autowired
//    public UserDaoImpl(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

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
//    @Override
//    public List<User> getAllUsers() {
//
//        Session session = sessionFactory.getCurrentSession();
//        List<User> allUsers= session.createQuery("from User", User.class)
//            .getResultList();
//        return allUsers;
//    }
//    @Override
//    public void saveUser (User user) {
//
//        Session session = sessionFactory.getCurrentSession();
//        entityManager.createQuery(saveUser(user);
//    }

//    @Override
//    public User getUserByID(Long id) {
//
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(User.class, id);
//        return null;
//    }

//    @Override
//    public void editUserByID(Long id) {

//        User userToBeUpdated = getUserByID(id);
//        userToBeUpdated.setName(updatedUser.getName());
//        userToBeUpdated.setSurname(updatedUser.getSurname());
//        userToBeUpdated.setEmail(updatedUser.getEmail());
//    }
//    @Override
//    public void deleteUserByID(Long id) {
//
//        User user = new User();
//
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(getUserByID(id));
//    }

//    @Override
//    public void update(Long id, User updatedUser) {
//
//        User userToBeUpdated = getUserByID(id);
//        userToBeUpdated.setName(updatedUser.getName());
//        userToBeUpdated.setSurname(updatedUser.getSurname());
//        userToBeUpdated.setEmail(updatedUser.getEmail());

//        Session session = sessionFactory.getCurrentSession();
//        session.update(user);
//    }
//}
