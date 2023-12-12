package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.models.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
public class UserController {
    UserService userService = new UserServiceImpl();

    @GetMapping(value = "/users")
    public String printAllUsers(ModelMap model) {
        List<User> users = userService.loadAllUsers();
        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping(value = "users/add_User")
    public String getUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "add_User";
    }

    @PostMapping(value = "users/add_User")
    public String addUser(@ModelAttribute User user, ModelMap model) {
        userService.saveUser(user);
        return "add_User";
    }
}
