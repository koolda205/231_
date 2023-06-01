package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    void addUserInUserList(String name, String lastName, String email);

    List<User> getUserlist(Long count);

    void add(User user);

    void update(User user);

    void getUserByID(Long id);

    void deleteUserByID(Long id);

}

