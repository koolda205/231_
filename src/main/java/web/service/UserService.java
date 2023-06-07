package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

//    void addUserInUserList(String name, String lastName, String email);
//
//    List<User> getUserlist(Long id);
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

    User getUserByID(Long id);

    void editUserByID(Long id);

    void deleteUserByID(Long id);


}

