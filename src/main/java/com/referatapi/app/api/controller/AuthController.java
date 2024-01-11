package com.referatapi.app.api.controller;

import com.referatapi.app.api.model.Tag;
import com.referatapi.app.api.model.Ticket;
import com.referatapi.app.api.repository.TagRepository;
import com.referatapi.app.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.referatapi.app.api.model.User;
import java.util.List;
import java.util.Objects;

@RestController
public class AuthController {

    private UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createTicket(@RequestBody User reqUser) {
        User dbUser = userRepository.findByEmail(reqUser.getEmail());
        User user;

        if(dbUser.getPassword().equals(reqUser.getPassword())){
            user = new User(dbUser.getId(), dbUser.getName());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        user = new User(dbUser.getId(), dbUser.getName());
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

}