package ru.gavrilov.CRUD.CRUDspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.gavrilov.CRUD.CRUDspring.model.User;
import ru.gavrilov.CRUD.CRUDspring.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all-users")
    public String ShowUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "ShowUsers";
    }

    @GetMapping("/add-new-user")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping("/save-new-user")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users/all-users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users/all-users";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam("id") Long id, Model model) {
        User user = userService.findUser(id);
        model.addAttribute("user", user);
        return "userEditForm";
    }

    @PostMapping("/update-user")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users/all-users";
    }
}
