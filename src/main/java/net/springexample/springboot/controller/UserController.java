package net.springexample.springboot.controller;

import net.springexample.springboot.model.User;
import net.springexample.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsers(Model model, User user) {
        model.addAttribute("userList", userService.findAll());
        return "users";
    }
    @PostMapping("/users")
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping("/update-user/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "update-user";
    }

    @PutMapping("/update-user")
    public String updateUser(User user) {
        userService.update(user);
        return "redirect:/users";
    }
}
