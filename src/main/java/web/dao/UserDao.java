package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    void addUserInUserList(String name, String surName, String email);

    List<User> getUsersList();

    void add(User user);

    void update(User user);



}
