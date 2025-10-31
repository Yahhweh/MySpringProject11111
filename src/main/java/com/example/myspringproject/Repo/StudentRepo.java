package com.example.myspringproject.Repo;

import com.example.myspringproject.Classes.Room;
import com.example.myspringproject.Classes.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;


public interface StudentRepo extends JpaRepository<Student, Long> {
    Collection<Student> findByRoom(Room room);

    
}
