package com.example.myspringproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<Student> showAllStudents()
    {
        return studentService.showAllStudents();
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId)
    {
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/put/{studentId}")
    public void updateStudent(@PathVariable Long studentId,
                              @RequestParam(value = "room", required = false) String room,
                              @RequestParam(value = "course", required = false) Integer course,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "sureName", required = false) String sureName)
    {
        studentService.updateStudent(studentId, room, course, name,sureName);
    }
}
