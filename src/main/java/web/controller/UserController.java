package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public String printAllUsers(ModelMap model) {
        List<User> users = userService.loadAllUsers();
        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping(value = "users/add_User")
    public String getUserToSave(ModelMap model) {
        model.addAttribute("user", new User());
        return "add_User";
    }

    @PostMapping(value = "users/add_User")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "add_User";
    }

    @GetMapping(value = "/users/remove_User")
    public String showRemovePage() {
        return "remove_User";
    }

    @PostMapping(value = "/users/remove_User")
    public String removeUser(@RequestParam(value = "userId") String userId, ModelMap model) {
        List<Long> usersIds = new ArrayList<>();
        List<User> users = userService.loadAllUsers();
        long Id = Long.parseLong(userId);

        for(User user : users) {
            usersIds.add(user.getId());
        }

        if (usersIds.contains(Id)) {
            userService.removeUserById(Id);
            model.addAttribute("msg", "Successfully removed user");
        } else {
            model.addAttribute("msg", "Incorrect user id");
        }

        return "remove_User";
    }

    @GetMapping(value = "users/change_User")
    public String addUserToChange(ModelMap model) {
        model.addAttribute("user", new User());
        return "change_User";
    }

    @PostMapping(value = "users/change_User")
    public String changeUser(@ModelAttribute User user, ModelMap model) {
        List<Long> usersIds = new ArrayList<>();
        List<User> users = userService.loadAllUsers();

        for(User userForList : users) {
            usersIds.add(userForList.getId());
        }

        if (usersIds.contains(user.getId())) {
            userService.changeUser(user);
            model.addAttribute("msg", "Successfully changed user");
        } else {
            model.addAttribute("msg", "Incorrect user id");
        }

        return "change_User";
    }
}
