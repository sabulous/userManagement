package com.sabulous.userManagement.services;

import java.util.List;
import com.sabulous.userManagement.model.User;

public interface UserService {
    List<User> getAllUsers();
    User getUser(int id);
    void addUser(User user);
    void deleteUser(int id);
    void printUsers();
}