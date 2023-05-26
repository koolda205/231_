package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String printCars(@RequestParam(value = "count", required = false) Long count,
                            ModelMap modelMap) {

        modelMap.addAttribute("users", userService.getUserlist(count));
        return "users";
    }
}


