package com.example.myspringproject.Controller;

import com.example.myspringproject.DTO.StudentShortedDTO;
import com.example.myspringproject.entity.Student;
import com.example.myspringproject.entity.StudentDTO;
import com.example.myspringproject.DTO.StudentResponseDTO;
import com.example.myspringproject.Repo.StudentRepo;
import com.example.myspringproject.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class StudentController {

    StudentService studentService;
    StudentRepo studentRepo;

    @Autowired
    public StudentController(StudentService studentService, StudentRepo studentRepo) {
        this.studentService = studentService;
        this.studentRepo = studentRepo;
    }

    @GetMapping
    @RequestMapping("/students")
    public List<StudentShortedDTO> showAllStudents()
    {
        return studentService.showAllStudents();
    }

    @GetMapping
    @RequestMapping("/students/detailed")
    public List<StudentResponseDTO> showAllDetailedStudents()
    {
        return studentService.showAllDetailedStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentDTO student)
    {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable Long studentId)
    {
        studentService.deleteStudent(studentId);
    }

    @Transactional
    @PutMapping("/students/put/{studentId}")
    public void updateStudent(@PathVariable Long studentId,
                              @RequestParam(value = "room", required = false) String room,
                              @RequestParam(value = "course", required = false) Integer course,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "sureName", required = false) String sureName)
    {
        studentService.updateStudent(studentId, room, course, name,sureName);
    }

}
