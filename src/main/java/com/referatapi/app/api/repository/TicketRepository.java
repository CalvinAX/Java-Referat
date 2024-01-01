package com.referatapi.app.api.repository;

import com.referatapi.app.api.model.Ticket;
import com.referatapi.app.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {

}
