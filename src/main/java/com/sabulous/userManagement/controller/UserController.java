package com.sabulous.userManagement.controller;

import com.sabulous.userManagement.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping("/users/{id}")
    public String getUserDetails(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "userDetails";
    }
    
    @RequestMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}