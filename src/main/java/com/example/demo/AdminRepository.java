package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByUsernameAndPassword(Integer username, String password);
    Optional<Admin> findByUsername(Integer username);
}
