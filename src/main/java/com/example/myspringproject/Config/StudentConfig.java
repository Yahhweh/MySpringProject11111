import com.example.myspringproject.Classes.Room;
import com.example.myspringproject.Repo.RoomRepo;
import com.example.myspringproject.Repo.StudentRepo;
import com.example.myspringproject.Classes.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Bean
CommandLineRunner commandLineRunner(RoomRepo roomRepo, StudentRepo studentRepo) {
    return args -> {
        studentRepo.deleteAll();
        roomRepo.deleteAll();

        Room room209A = new Room("209A", 1);
        Room room1202A = new Room("1202A", 1);
        Room room811A = new Room("811A", 1);

        roomRepo.saveAll(List.of(room209A, room1202A, room811A));

        var students = List.of(
                new Student("Kirill", "Kovalenko", 1, "IT", room209A),
                new Student("Karina", "Shevchenko", 1, "IT", room1202A),
                new Student("Amir", "Kuskeev", 1, "IT", room811A)
        );

        studentRepo.saveAll(students);
    };
}

void main() {
}
