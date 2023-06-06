package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
//
//    void addUserInUserList(String name, String lastName, String email);
//
//    List<User> getUsersList();
//
//    void add(User user);
//
//    void update(User user);
//
//    User getUserByID(Long id);
//
//    void deleteUserByID(Long id);

    List<User> getAllUsers();

    void saveUser (User user);

}
