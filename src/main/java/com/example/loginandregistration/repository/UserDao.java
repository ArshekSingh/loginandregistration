package com.example.loginandregistration.repository;

import com.example.loginandregistration.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);

    User getPassword();
}
