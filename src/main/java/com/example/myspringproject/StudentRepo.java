package com.example.myspringproject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface StudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findByRoom(String room);
}
