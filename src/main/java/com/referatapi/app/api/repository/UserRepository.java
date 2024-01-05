package com.referatapi.app.api.repository;

import com.referatapi.app.api.model.Ticket;
import com.referatapi.app.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}