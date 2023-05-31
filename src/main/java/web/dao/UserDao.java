package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void addUserInUserList(String name, String surname, String email);

    List<User> getUsersList();

    void add(User user);



}
