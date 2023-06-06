package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void addUserInUserList(String name, String lastName, String email) {
        userDao.addUserInUserList(name, lastName, email);
    }

//    @Transactional(readOnly = true)
//    @Override
//    public List<User> getUserlist(Long count) {
//        List<User> users = userDao.getUsersList();
//        List<User> users2 = new ArrayList<>();
//        if (count == null || count <= 0 || count > 5) {
//            return users;
//        } else {
//            for (int i = 0; i < count; i++) {
//                users2.add(users.get(i));
//            }
//        }
//        return users2;
//    }

//    @Transactional(readOnly = true)
//    @Override
//    public List<User> getUserlist(Long count) {
//        List<User> users = userDao.getUsersList();
//        List<User> users2 = new ArrayList<>();
//        if (count == null || count <= 0 || count > users.size()) {
//            return users;
//        } else {
//            for (int i = 0; i < count; i++) {
//                users2.add(users.get(i));
//            }
//        }
//        return users2;
//    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getUserlist(Long count) {
        List<User> users = userDao.getUsersList();
        List<User> users2 = new ArrayList<>();
        if (count == null || count <= 0 || count > users.size()) {
            return users;
        } else {
            for (int i = 0; i < count; i++) {
                users2.add(users.get(i));
            }
        }
        return users2;
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    @Override
    public User getUserByID(Long id) {
        return userDao.getUserByID(id);
    }

    @Transactional
    @Override
    public void deleteUserByID(Long id) {
        userDao.deleteUserByID(id);
    }
}


