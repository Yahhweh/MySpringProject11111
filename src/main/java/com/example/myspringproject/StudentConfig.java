package com.example.myspringproject;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Configuration
public class StudentConfig {
    StudentRepo studentRepo;

    public StudentConfig(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return (args) -> {
            studentRepo.deleteAll();

            var students = List.of(
                    new Student("kirill", "Kovalenko", 1,"209A"),
                    new Student("karina", "Shewchenko", 1,"1202A"),
                    new Student("Amir", "Kuskeev", 1,"811A")
            );
            studentRepo.saveAll(students);
        };
    }

}
