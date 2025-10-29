package com.example.myspringproject.config;

import com.example.myspringproject.Classes.Course;
import com.example.myspringproject.Classes.CourseShortDTO;
import com.example.myspringproject.Classes.Room;
import com.example.myspringproject.Repo.CourseRepo;
import com.example.myspringproject.Repo.RoomRepo;
import com.example.myspringproject.Repo.StudentRepo;
import com.example.myspringproject.Classes.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
 class DataConfig {

    @Bean
    CommandLineRunner commandLineRunner(RoomRepo roomRepo, StudentRepo studentRepo, CourseRepo courseRepo) {
        return args -> {
            System.out.println("🔵 Starting data initialization...");

            studentRepo.deleteAll();
            roomRepo.deleteAll();
            courseRepo.deleteAll();

            Room room209A = roomRepo.save(new Room("209A", 1));
            Room room1202A = roomRepo.save(new Room("1202A", 1));
            Room room811A = roomRepo.save(new Room("811A", 1));
            Room room1302A = roomRepo.save(new Room("1302A", 1));

            System.out.println("✅ Rooms saved: " + roomRepo.count());


            Course It = new Course();
            It.setName("IT");
            It.setCapacity(0);
            It.setStudents(List.of());
            It = courseRepo.save(It);

            System.out.println("✅ Courses saved: " + courseRepo.count());

            studentRepo.save(new Student("Kirill", "Kovalenko", 1, It, room209A));
            studentRepo.save(new Student("Karina", "Shevchenko", 1, It, room1202A));
            studentRepo.save(new Student("Amir", "Kuskeev", 1, It, room811A));
            studentRepo.save(new Student("Nikita", "Protas", 1, It, room1302A));

            System.out.println("✅ Students saved: " + studentRepo.count());

        };
    }

}
