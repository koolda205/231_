package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;



@Controller
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/")
//    public String findUsersById(@RequestParam(value = "count", required = false) Long count,
//                            ModelMap modelMap) {
//
//        modelMap.addAttribute("users", userService.getUserlist(count));
//        return "users";
//    }
//    @GetMapping("/delete")
//    public String deleteUserById(@RequestParam(value = "id", required = false) Long id,
//                                 ModelMap modelMap) {
//
//        user = (User) userService.getUserlist(id);
//
//        modelMap.addAttribute("id", user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/create")
//    public String create(ModelMap modelMap) {
//
//        modelMap.addAttribute("user", new User());
//        return "redirect:/users";
//    }
//
//    @PostMapping("/add")
//    public String add(@ModelAttribute("user") User user) {
//
//        userService.add(user);
//        return "redirect:/users";
//    }
//}//    @GetMapping("/{id}")
////    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
////
////        modelMap.addAttribute("users", userService.getUserByID(id));
////        return "users/show";
////    }



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
    //    @PatchMapping("/{id}")
//    public String update (@ModelAttribute("user") User user,
//                          @PathVariable("id") Long id) {
//        userService.getUserByID(id);
//        return "redirect:/";
//    }

///////////ниже рабочие версии/////////////////////

//    @RequestMapping("/")
//    public String showAllUsers(Model model) {
//
//        List<User> allUsers = userService.getAllUsers();
//        model.addAttribute("allUsers", allUsers);
//
//        return "all-users";
//    }


//    @RequestMapping("/addNewUser")
//    public String addNewUser(@RequestParam("name") String name,
//                             @RequestParam("surname") String surname,
//                             @RequestParam("email") String email,
//                                 Model model){
//
//        User user = new User();
//        user.setName(name);
//        user.setSurname(surname);
//        user.setEmail(email);
//
//        model.addAttribute("user", user);
//
//        userService.saveUser(user);
//
//        return "redirect:/";
//    }


    @GetMapping("/")
    public String showAllUsers(Model model) {

        model.addAttribute("allUsers", userService.getAllUsers());

        return "all-users";
    }

    @PostMapping("/addNewUser")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);

        return "redirect:/";
    }

    @GetMapping("/findUsersById")
    public String findUsersById(@RequestParam(value = "id", required = false) Long id,
                            Model model) {

        model.addAttribute("user", userService.getUserByID(id));
        return "user-info";
    }

    @GetMapping("/editUsersById/{id}")
    public String edit(Model model, @PathVariable("id") Long id) {

        model.addAttribute("user", userService.getUserByID(id));
        model.addAttribute("allUsers", userService.getAllUsers());
        return "redirect:/";
    }


    @DeleteMapping("/deleteUserById")
    public String deleteUser(@PathVariable("id") Long id) {

        userService.deleteUserByID(id);

        return "redirect:/";
    }


}