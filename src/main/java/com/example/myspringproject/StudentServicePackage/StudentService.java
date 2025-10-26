package com.example.myspringproject.StudentServicePackage;

import com.example.myspringproject.Classes.Room;
import com.example.myspringproject.Classes.Student;
import com.example.myspringproject.Classes.StudentDTO;
import com.example.myspringproject.Repo.RoomRepo;
import com.example.myspringproject.Repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final RoomRepo roomRepo;
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo, RoomRepo roomRepo) {
        this.studentRepo = studentRepo;
        this.roomRepo = roomRepo;
    }

    public List<Student> showAllStudents() {
        return studentRepo.findAll();
    }

    public Student createStudent(StudentDTO studentDTO) {
        if(studentDTO.getYear() < 1 || studentDTO.getYear() > 4)
            throw new IllegalArgumentException("incorrect course");

        String roomNumber = studentDTO.getRoom();

        if(roomRepo.findRoomByRoomNumber(roomNumber).isPresent())
        {
            Room room = roomRepo.findRoomByRoomNumber(roomNumber).orElseThrow();
            int capacity = room.getCapacity();
            room.setCapacity(capacity+1);
        }
            Room room = roomRepo.findRoomByRoomNumber(roomNumber).orElseGet(() -> roomRepo.save(new Room(roomNumber, 1)));
        if(!validationOfData.checkValidationOfName(studentDTO.getName()))
            throw new IllegalArgumentException("name should has only letters");
        if(!validationOfData.checkValidationOfName(studentDTO.getSureName()))
            throw new IllegalArgumentException("sureName should has only letters");

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setSureName(studentDTO.getSureName());
        student.setYear(studentDTO.getYear());
        student.setCourse(studentDTO.getCourse());
        student.setRoom(room);

        return studentRepo.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(studentRepo.findById(studentId).isEmpty())
            throw new IllegalArgumentException("students does not exists");
        studentRepo.deleteById(studentId);
    }

    public void updateStudent(Long studentId, String roomNumber, Integer year, String name, String sureName) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        if(roomNumber != null) {
            Room room = roomRepo.findRoomByRoomNumber(roomNumber)
                    .orElseGet(() -> roomRepo.save(new Room(roomNumber, 1)));
            student.setRoom(room);
        }

        if(year != null) student.setYear(year);

        if(name != null) {
            if(!validationOfData.checkValidationOfName(name))
                throw new IllegalArgumentException("name should has only letters");
            student.setName(name);
        }

        if(sureName != null) {
            if(!validationOfData.checkValidationOfName(sureName))
                throw new IllegalArgumentException("sureName should has only letters");
            student.setSureName(sureName);
        }

        studentRepo.save(student);
    }
}
