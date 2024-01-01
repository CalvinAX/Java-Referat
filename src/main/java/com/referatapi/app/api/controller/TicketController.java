package com.referatapi.app.api.controller;

import com.referatapi.app.api.model.Ticket;
import com.referatapi.app.api.repository.TicketRepository;
import com.referatapi.app.api.repository.UserRepository;
import com.referatapi.app.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TicketController {

    private TicketService ticketService;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketController(TicketService ticketService, TicketRepository ticketRepository) {
        this.ticketService = ticketService;
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/tickets")
    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
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
    public Ticket getSingleTicket(@PathVariable("id") Integer id) {
        return ticketRepository.findById(id).get();
    }
}
