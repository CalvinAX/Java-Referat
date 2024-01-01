package com.referatapi.app.service;


import com.referatapi.app.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "Test", 50, "test@test.com", "test");
        User user2 = new User(2, "Malte", 87, "malte@test.com", "test");
        User user3 = new User(3, "Uwe", 13, "uwe@test.com", "test");

        userList.addAll(Arrays.asList(user1, user2, user3));
    }

    public Optional<User> getUser(Integer id) {
        Optional optional = Optional.empty();
        for (User user : userList) {
            if (id == user.getId()) {
                optional = Optional.of(user);
                return optional;
            }
        }
        return optional;
    }

    public List<User> getUsersList() {
        return userList;
    }
}
