package com.referatapi.app.api.repository;

import com.referatapi.app.api.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    List<Ticket> findByTitleStartingWith(String title);
}
