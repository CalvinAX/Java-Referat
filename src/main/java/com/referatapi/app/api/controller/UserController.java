package com.referatapi.app.api.controller;


import com.referatapi.app.api.model.User;
import com.referatapi.app.api.repository.UserRepository;
import com.referatapi.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /*@GetMapping("/user")
    public User getUser(@RequestParam Integer id) {
        Optional<User> user = userService.getUser(id);
        if (user.isPresent()) {
            return (User) user.get();
        }
        return null;
    }*/

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User toCreate = new User(user.getName(), user.getAge(), user.getEmail(), user.getPassword());
        userRepository.save(toCreate);

        return new ResponseEntity<>(toCreate, HttpStatus.CREATED);
    }

    @PostMapping(value = "/user/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updatedUser = new User(user.getId(), user.getName(), user.getAge(), user.getEmail(), user.getPassword());
        userRepository.save(updatedUser);

        return new ResponseEntity<>(updatedUser, HttpStatus.ACCEPTED);
    }

}
