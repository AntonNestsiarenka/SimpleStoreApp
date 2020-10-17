package com.example.MyFirstWebApp.repository;

import com.example.MyFirstWebApp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);
    User findByEmail(String email);
    User findById(int id);
}
