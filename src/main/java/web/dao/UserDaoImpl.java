package web.dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    private List<User> usersList = new ArrayList<>();
    private static Long count = 0L;

    {
        usersList.add(new User(++count, "Tom", "Jones", "TJ@mail.dj"));
        usersList.add(new User(++count, "Rom", "Tos", "RT@mail.dj"));
        usersList.add(new User(++count, "Weom", "Poos", "WP@mail.dj"));
        usersList.add(new User(++count, "Weom1", "Poos1", "WP1@mail.dj"));
        usersList.add(new User(++count, "Weom2", "Poos2", "WP2@mail.dj"));

    }

    public void addUserInUserList(String name, String surname, String email) {
        usersList.add(new User(++count, "Name","SurName", "email@mail.dj"));
    }

    public List<User> getUsersList() {
        return usersList;
    }
}
