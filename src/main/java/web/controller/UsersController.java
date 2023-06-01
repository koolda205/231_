package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
//@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired (required = true)
//    @Qualifier (value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String getUserList (Model model) {

        model.addAttribute("users", userService.getUserlist());
//        model.addAttribute("users", new User());
//        model.addAttribute("getUserList", userService.getUserlist());

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String add (@ModelAttribute("user") User user) {

        if (user.getId() == 0) {
                userService.add(user);
        } else {
                userService.update(user);
        }
        return "redirect:/users";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser (@PathVariable("id") Long id) {

        userService.deleteUserByID(id);

        return "redirect:/users";
    }
    @RequestMapping("/edit/{id}")
    public String editUser (@PathVariable("id") Long id,
                            Model model) {
        model.addAttribute("users", userService.getUserByID(id));
        model.addAttribute("getUserList", userService.getUserlist());

        return "users";
    }

    @RequestMapping("/userdata/{id}")
    public String userData (@PathVariable("id") Long id, Model model) {

        model.addAttribute("users", userService.getUserByID(id));

        return "userdata";
    }
}


