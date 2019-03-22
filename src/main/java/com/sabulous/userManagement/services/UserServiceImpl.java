package com.sabulous.userManagement.services;

import java.util.ArrayList;
import java.util.List;

import com.sabulous.userManagement.model.User;

import org.springframework.stereotype.Component;

@Component
class UserServiceImpl implements UserService {

    private List<User> users;

    public UserServiceImpl() {
        initUsers();       
    }
    
    private void initUsers() {
        users = new ArrayList<User>();
        for(int i = 0; i < 5; i++) {
            User user = new User(i, "User-" + i, "RoleGroup-" + i);
            addUser(user);
        }
    }

    public void printUsers() {
        for(User u : users) {
            u.introduce();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public User getUser(int id) {
        for(User u : users) {
            if(u.getId() == id) return u;
        }
        return null;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(int id) {
        User u = getUser(id);
        if(u != null)
            users.remove(u);
    }
}