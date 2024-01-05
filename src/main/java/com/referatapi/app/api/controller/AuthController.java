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

import java.util.List;

@RestController
public class AuthController {
/*
    private TagService tagService;
    private TagRepository tagRepository;

    @Autowired
    public AuthController(UserService userService, UserRepository userRepository) {
        // this.userService = userService;
        // this.userRepository = userRepository;
    }

    @PostMapping(value = "/auth/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> createTicket(@RequestBody User user) {
        userRepository.findById(user.email).get();
        Ticket toCreate = new Ticket(ticket.getTitle(), ticket.getDescription(), ticket.getCreator(), ticket.getClosedBy(), ticket.getAssignee(), ticket.getStatus(), ticket.getPriority(), ticket.getCreatedAt(), ticket.getDeadline());
        ticketRepository.save(toCreate);
        return new ResponseEntity<>(toCreate, HttpStatus.CREATED);
    }
*/
}