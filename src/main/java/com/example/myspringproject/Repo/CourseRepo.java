package com.example.myspringproject.Repo;

import com.example.myspringproject.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findByName(String name);

}
