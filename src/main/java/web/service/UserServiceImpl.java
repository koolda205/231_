package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public List<User> getUserlist(Long count) {
        List<User> users = userDao.getUsersList();
        List<User> users2 = new ArrayList<>();
        if (count == null || count <= 0 || count > 5) {
            return users;
        } else {
            for (int i = 0; i < count; i++) {
                users2.add(users.get(i));
            }
        }
        return users2;
    }
}


