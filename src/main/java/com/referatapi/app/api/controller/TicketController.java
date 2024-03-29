package com.referatapi.app.api.controller;

import com.referatapi.app.api.model.Ticket;
import com.referatapi.app.api.model.TicketsTags;
import com.referatapi.app.api.repository.TicketRepository;
import com.referatapi.app.api.repository.TicketsTagsRepository;
import com.referatapi.app.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.referatapi.app.api.model.User;


import java.util.List;

@RestController
public class TicketController {

    private TicketRepository ticketRepository;
    private TicketsTagsRepository ticketsTagsRepository;

    @Autowired
    public TicketController(TicketRepository ticketRepository, TicketsTagsRepository ticketsTagsRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketsTagsRepository = ticketsTagsRepository;
    }

    // Gibt alle Tickets aus
    @GetMapping("/tickets")
    public ResponseEntity<List<Ticket>> getTickets() {
        List<Ticket> ticketsFromDB = ticketRepository.findAll();
        for (Ticket ticket : ticketsFromDB) {
            if (ticket.getClosedBy() != null) {
                User user = new User(ticket.getClosedBy().getId(), ticket.getClosedBy().getName());
                ticket.setClosedBy(user);
            }
            if (ticket.getCreator() != null) {
                User user = new User(ticket.getCreator().getId(), ticket.getCreator().getName());
                ticket.setCreator(user);
            }
            if (ticket.getAssignee() != null) {
                User user = new User(ticket.getAssignee().getId(), ticket.getAssignee().getName());
                ticket.setAssignee(user);
            }
        }
        return new ResponseEntity<>(ticketsFromDB, HttpStatus.OK);
    }

    // Filter die Tickets nach ihrem Titel und gibt diese aus
    @GetMapping("/tickets/filter-by-title")
    // RequestParam url encoded ?title=test
    public ResponseEntity<List<Ticket>> getTicketsByName(@RequestParam String title) {
        List<Ticket> filteredTickets = ticketRepository.findByTitleStartingWith(title);

        for (Ticket ticket : filteredTickets) {
            if (ticket.getClosedBy() != null) {
                User user = new User(ticket.getClosedBy().getId(), ticket.getClosedBy().getName());
                ticket.setClosedBy(user);
            }
            if (ticket.getCreator() != null) {
                User user = new User(ticket.getCreator().getId(), ticket.getCreator().getName());
                ticket.setCreator(user);
            }
            if (ticket.getAssignee() != null) {
                User user = new User(ticket.getAssignee().getId(), ticket.getAssignee().getName());
                ticket.setAssignee(user);
            }
        }

        return ResponseEntity.ok(filteredTickets);
    }

    // Gibt ein Ticket mit einer bestimmten Id aus
    @GetMapping("/ticket/{id}")
    public ResponseEntity<Ticket> getSingleTicket(@PathVariable("id") Integer id) {
        // Ticket über die ID in der Datenbank finden und in Variable speichern
       Ticket ticketFromDB = ticketRepository.findById(id).get();

       // ClosedBy user für das ticket-Object setzen
       User userClosedBy = new User(ticketFromDB.getClosedBy().getId(), ticketFromDB.getClosedBy().getName());
       ticketFromDB.setClosedBy(userClosedBy);
        // Creator user für das ticket-Object setzen
       User userCreator = new User(ticketFromDB.getCreator().getId(), ticketFromDB.getCreator().getName());
       ticketFromDB.setCreator(userCreator);
        // Assignee user für das ticket-Object setzen
        User userAssignee = new User(ticketFromDB.getAssignee().getId(), ticketFromDB.getAssignee().getName());
        ticketFromDB.setAssignee(userAssignee);

        // Rückgabe des Tickets
        return new ResponseEntity<>(ticketFromDB, HttpStatus.OK);
    }

    // Entfernt ein Ticket mit einer bestimmten Id
    @GetMapping("/tickets/delete/{id}")
    public void deleteTickets(@PathVariable("id") Integer id) {
        ticketRepository.deleteById(id);
    }

    @GetMapping("/ticket/test/{id}")
    public List<TicketsTags> getSingleTicketTag(@PathVariable("id") Integer id) {
        return ticketsTagsRepository.findAllByTicketId(id);
    }

    // Erstellt ein neues Ticket
    @PostMapping(value = "/ticket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket toCreate = new Ticket(ticket.getTitle(), ticket.getDescription(), ticket.getCreator(), ticket.getClosedBy(), ticket.getAssignee(), ticket.getStatus(), ticket.getPriority(), ticket.getCreatedAt(), ticket.getDeadline());
        ticketRepository.save(toCreate);
        return new ResponseEntity<>(toCreate, HttpStatus.CREATED);
    }

    // Updated die Daten eines bereits bestehenden Tickets
    @PostMapping(value = "/ticket/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        Ticket updatedTicket = new Ticket(ticket.getId(), ticket.getTitle(), ticket.getDescription(), ticket.getCreator(), ticket.getClosedBy(), ticket.getAssignee(), ticket.getStatus(), ticket.getPriority(), ticket.getCreatedAt(), ticket.getDeadline());
        ticketRepository.save(updatedTicket);

        return new ResponseEntity<>(updatedTicket, HttpStatus.ACCEPTED);
    }

}
