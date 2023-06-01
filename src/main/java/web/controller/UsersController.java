package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

//        model.addAttribute("users", new User());
        model.addAttribute("users", userService.getUserlist());

        return "users";
    }



//    @Autowired
//    public UsersController(UserService userService) {
//        this.userService = userService;
//    }

//    @GetMapping()
//    public String printUsers(@RequestParam(value = "count", required = false) Long count,
//                             ModelMap modelMap) {
//
//        modelMap.addAttribute("users", userService.getUserlist(count));
//        return "users";
//    }


//    @GetMapping()
//    public String printUsers(@RequestParam(value = "count", required = false) Long count,
//                            ModelMap modelMap) {
//
//        modelMap.addAttribute("users", userService.getUserlist(count));
//        return "users";
//    }

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
}


