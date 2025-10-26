package com.example.myspringproject.config;

import com.example.myspringproject.Classes.Room;
import com.example.myspringproject.Repo.RoomRepo;
import com.example.myspringproject.Repo.StudentRepo;
import com.example.myspringproject.Classes.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 class DataConfig {

    @Bean
    CommandLineRunner commandLineRunner(RoomRepo roomRepo, StudentRepo studentRepo) {
        return args -> {
            System.out.println("🔵 Starting data initialization...");

            studentRepo.deleteAll();
            roomRepo.deleteAll();

            Room room209A = roomRepo.save(new Room("209A", 1));
            Room room1202A = roomRepo.save(new Room("1202A", 1));
            Room room811A = roomRepo.save(new Room("811A", 1));

            System.out.println("✅ Rooms saved: " + roomRepo.count());

            studentRepo.save(new Student("Kirill", "Kovalenko", 1, "IT", room209A));
            studentRepo.save(new Student("Karina", "Shevchenko", 1, "IT", room1202A));
            studentRepo.save(new Student("Amir", "Kuskeev", 1, "IT", room811A));

            System.out.println("✅ Students saved: " + studentRepo.count());
        };
    }

}
