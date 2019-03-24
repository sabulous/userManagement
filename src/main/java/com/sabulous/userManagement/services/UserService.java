package com.sabulous.userManagement.services;

import java.util.List;
import com.sabulous.userManagement.model.User;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(int id);
    User addOrEditUser(User user);
    void deleteUser(int id);
    void printUsers();
    int findNextId();
}
