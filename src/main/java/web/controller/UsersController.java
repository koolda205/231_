package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/")
public class UsersController {


    UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String findUsersById(@RequestParam(value = "count", required = false) Long count,
                            ModelMap modelMap) {

        modelMap.addAttribute("users", userService.getUserlist(count));
        return "users";
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
//
//        modelMap.addAttribute("users", userService.getUserByID(id));
//        return "users/show";
//    }

    @GetMapping("/new")
    public String newPerson(ModelMap modelMap) {

        modelMap.addAttribute("user", new User());
        return "redirect:/";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") User user) {

        userService.add(user);
        return "redirect:/";

    }
}

//    @GetMapping()
//    public String addUsers(@RequestParam(value = "name", required = false) String name,
//                           @RequestParam(value = "last_name", required = false) String lastName,
//                           @RequestParam(value = "email", required = false) String email,
//                           ModelMap modelMap) {
//
//        modelMap.addAttribute("users", userService.addUserInUserList(name, lastName, email));
//        return "users";
//    }

//    @GetMapping()
//    public String addUsers(@RequestParam(value = "user", required = false) User user,
//                              ModelMap modelMap) {
//
//        modelMap.addAttribute("users", userService.add(user));
//        return "users";
//    }
//}


