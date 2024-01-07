package com.referatapi.app.api.repository;

import com.referatapi.app.api.model.Ticket;
import com.referatapi.app.api.model.TicketsTags;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketsTagsRepository extends JpaRepository<TicketsTags, Integer> {
}
