package com.referatapi.app.service;

import com.referatapi.app.api.model.Ticket;
import com.referatapi.app.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private List<Ticket> ticketList;

    public TicketService() {
        ticketList = new ArrayList<>();

        Ticket ticket1 = new Ticket(1, "Test", "Test Ticket", 1, null, 1, "Open", "High");
        Ticket ticket2 = new Ticket(1, "Test2", "Test Ticket 2", 1, null, 1, "In Progress", "Medium");
        Ticket ticket3 = new Ticket(1, "Test3", "Test Ticket 3", 1, null, 1, "Testing", "Low");

        ticketList.addAll(Arrays.asList(ticket1, ticket2, ticket3));
    }

    public List<Ticket> getTickets() {
        return ticketList;
    }

    public Optional<Ticket> getSingleTicket(Integer id) {
        Optional optional = Optional.empty();
        for (Ticket ticket : ticketList) {
            if(id == ticket.getId()) {
                optional = Optional.of(ticket);
                return optional;
            }
        }
        return optional;
    }
}
