package com.sabulous.userManagement.controller;

import com.sabulous.userManagement.model.User;
import com.sabulous.userManagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping("/{id}")
    public String getUserDetails(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userDetails";
    }
    
    @RequestMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User(userService.findNextId()));
        return "userForm";
    }
    
    @RequestMapping(value = "/edit/{id}")
    public String editUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userForm";
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


    @RequestMapping(method = RequestMethod.POST)
    public String addOrUpdateUser(User user) {
        userService.addOrEditUser(user);
        return "redirect:/users/" + user.getId();
    }

}
