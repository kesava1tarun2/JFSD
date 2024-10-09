package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByUsernameAndPassword(Long username, String password);
    Optional<Student> findByUsername(Long username);
    Optional<Student> findById(Long id);
}
