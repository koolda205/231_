package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserByID(Long id);

    void editUser(User user);

    void deleteUserByID(Long id);


}
