package com.referatapi.app.api.controller;

import com.referatapi.app.api.model.Ticket;
import com.referatapi.app.api.model.TicketsTags;
import com.referatapi.app.api.repository.TicketRepository;
import com.referatapi.app.api.repository.TicketsTagsRepository;
import com.referatapi.app.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TicketController {

    private TicketService ticketService;
    private TicketRepository ticketRepository;
    private TicketsTagsRepository ticketsTagsRepository;

    @Autowired
    public TicketController(TicketService ticketService, TicketRepository ticketRepository, TicketsTagsRepository ticketsTagsRepository) {
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;
        this.ticketsTagsRepository = ticketsTagsRepository;
    }

    @GetMapping("/tickets")
    public List<Ticket> getTickets() {

        return ticketRepository.findAll();
    }

    @GetMapping("/tickets/filter-by-title")
    public ResponseEntity<List<Ticket>> getTicketsByName(@RequestParam String title) {
        List<Ticket> filteredTickets = ticketRepository.findByTitleStartingWith(title);
        return ResponseEntity.ok(filteredTickets);
    }

    /*@GetMapping("/ticket")
    public Ticket getSingleTicket(@RequestParam Integer id) {
        Optional<Ticket> ticket = ticketService.getSingleTicket(id);
        if (ticket.isPresent()) {
            return (Ticket) ticket.get();
        }
        return null;
    }*/

    @GetMapping("/ticket/{id}")
    public Ticket getSingleTicket(@PathVariable("id") Integer id) {return ticketRepository.findById(id).get();}

    @GetMapping("/tickets/delete/{id}")
    public void deleteTickets(@PathVariable("id") Integer id) {
        ticketRepository.deleteById(id);
    }

    @GetMapping("/ticket/test/{id}")
    public List<TicketsTags> getSingleTicketTag(@PathVariable("id") Integer id) {
        return ticketsTagsRepository.findAllByTicketId(id);
    }

    @PostMapping(value = "/ticket", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket toCreate = new Ticket(ticket.getTitle(), ticket.getDescription(), ticket.getCreator(), ticket.getClosedBy(), ticket.getAssignee(), ticket.getStatus(), ticket.getPriority(), ticket.getCreatedAt(), ticket.getDeadline());
        ticketRepository.save(toCreate);
        return new ResponseEntity<>(toCreate, HttpStatus.CREATED);
    }

    @PostMapping(value = "/ticket/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        Ticket updatedTicket = new Ticket(ticket.getId(), ticket.getTitle(), ticket.getDescription(), ticket.getCreator(), ticket.getClosedBy(), ticket.getAssignee(), ticket.getStatus(), ticket.getPriority(), ticket.getCreatedAt(), ticket.getDeadline());
        ticketRepository.save(updatedTicket);

        return new ResponseEntity<>(updatedTicket, HttpStatus.ACCEPTED);
    }

}
