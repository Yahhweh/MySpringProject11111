package com.example.myspringproject.service;

import com.example.myspringproject.DTO.StudentResponseDTO;
import com.example.myspringproject.DTO.StudentShortedDTO;
import com.example.myspringproject.Repo.CourseRepo;
import com.example.myspringproject.Repo.RoomRepo;
import com.example.myspringproject.Repo.StudentRepo;
import com.example.myspringproject.entity.Course;
import com.example.myspringproject.entity.Room;
import com.example.myspringproject.entity.Student;
import com.example.myspringproject.DTO.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final RoomRepo roomRepo;
    private final StudentRepo studentRepo;
    private  final CourseRepo courseRepo;

    public StudentService(StudentRepo studentRepo, RoomRepo roomRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.roomRepo = roomRepo;
        this.courseRepo = courseRepo;
    }


   public List<StudentResponseDTO> showAllDetailedStudents() {
        List<StudentResponseDTO> list = new ArrayList<>();

        List<Student> studentList =  studentRepo.findAll();

        for (Student student : studentList) {
            list.add((ToStudentResponseDTO.toStudentResponseDTOMethod(student)));
        }

        return list;
    }

    public List<StudentShortedDTO> showAllStudents()
    {
        List<StudentShortedDTO> list = new ArrayList<>();
        List<Student> studentList =  studentRepo.findAll();

        for(Student student: studentList)
        {
            list.add(new StudentShortedDTO(student.getName(), student.getSureName(), student.getRoom().getRoomNumber()));
        }
        return list;

    }



    public Student createStudent(StudentDTO studentDTO) {
        if(studentDTO.getYear() < 1 || studentDTO.getYear() > 4)
            throw new IllegalArgumentException("incorrect course");


        String roomNumber = studentDTO.getRoom();
        String courseName = studentDTO.getCourse();

        if(roomRepo.findRoomByRoomNumber(roomNumber).isPresent())
        {
            Room room = roomRepo.findRoomByRoomNumber(roomNumber).orElseThrow();
            int capacity = room.getCapacity();
            if(capacity + 1 > 2) throw new IllegalArgumentException("capacity cannot exceed 2");
            room.setCapacity(capacity+1);
        }

        if(courseRepo.findByName(courseName).isPresent()) {
            Course course = courseRepo.findByName(courseName).orElseThrow();
            int capacityCourse = course.getCapacity();
            course.setCapacity(capacityCourse + 1);
        }

        Course course = courseRepo.findByName(courseName).orElseGet(() -> courseRepo.save(new Course(courseName, 1)));
            Room room = roomRepo.findRoomByRoomNumber(roomNumber).orElseGet(() -> roomRepo.save(new Room(roomNumber, 1)));

        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setSureName(studentDTO.getSureName());
        student.setYear(studentDTO.getYear());
        student.setCourse(course);
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
            student.setName(name);
        }

        if(sureName != null) {

            student.setSureName(sureName);
        }

        studentRepo.save(student);
    }
}
