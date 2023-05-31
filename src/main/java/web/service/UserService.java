package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getUserlist(Long count);

    void add(User user);

}

