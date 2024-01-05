package com.referatapi.app.api.controller;

import com.referatapi.app.api.model.Tag;
import com.referatapi.app.api.model.Ticket;
import com.referatapi.app.api.repository.TagRepository;
import com.referatapi.app.api.repository.UserRepository;
import com.referatapi.app.service.TagService;
import com.referatapi.app.service.UserService;
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

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public AuthController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping(value = "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createTicket(@RequestBody User reqUser) {
        User dbUser = userRepository.findByEmail(reqUser.getEmail());

        // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        // BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
       // String hashedPassword = passwordEncoder.encode(plainPassword);
        int hashedPassword = dbUser.getPassword().hashCode();
        if(Integer.toString(hashedPassword).equals(reqUser.getPassword())){
            return new ResponseEntity<>("Successfuly logged in!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Access denied! Wrong email or password." + hashedPassword, HttpStatus.BAD_REQUEST);
    }

}