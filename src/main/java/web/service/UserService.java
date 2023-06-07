package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserByID(Long id);

    void editUser(User user);

    void deleteUserByID(Long id);


}

