package com.referatapi.app.api.repository;

import com.referatapi.app.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
