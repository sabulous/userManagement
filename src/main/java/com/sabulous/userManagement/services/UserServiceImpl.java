package com.sabulous.userManagement.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sabulous.userManagement.model.User;

import org.springframework.stereotype.Service;

@Service
class UserServiceImpl implements UserService {

    private Map<Integer, User> users;

    public UserServiceImpl() {
        initUsers();       
    }
    
    private void initUsers() {
        users = new HashMap<>();
        for(int i = 0; i < 5; i++) {
            User user = new User(findNextId(), "User-" + i, "RoleGroup-" + i);
            addOrEditUser(user);
        }
    }

    public void printUsers() {
        for(User u : users.values()) {
            u.introduce();
        }
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User getUserById(int id) {
        return users.get(id);
    }

    @Override
    public User addOrEditUser(User user) throws RuntimeException {
        if(user != null) {
            if(user.getId() == null) {
                user.setId(findNextId());
            }
            users.put(user.getId(), user);
            return user;
        } else {
            throw new RuntimeException("null element");
        }
    }

    @Override
    public void deleteUser(int id) {
        users.remove(id);
    }

    @Override
    public int findNextId() {
        if(users.isEmpty())
            return 0;
        return Collections.max(users.keySet()) + 1;
    }
}
