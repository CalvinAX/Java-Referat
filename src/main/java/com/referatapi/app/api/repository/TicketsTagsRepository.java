package com.referatapi.app.api.repository;

import com.referatapi.app.api.model.Ticket;
import com.referatapi.app.api.model.TicketsTags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketsTagsRepository extends JpaRepository<TicketsTags, Integer> {
    List<TicketsTags> findAllById(Integer id);
    @Query(value = "SELECT * FROM tickets_tags WHERE ticket_id = :id", nativeQuery = true)
    List<TicketsTags> findAllByTicketId(Integer id);
}
