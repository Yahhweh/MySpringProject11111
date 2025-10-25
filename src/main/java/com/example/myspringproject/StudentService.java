    package com.example.myspringproject;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class StudentService {
        StudentRepo studentRepo;

        public StudentService(StudentRepo studentRepo) {
            this.studentRepo = studentRepo;
        }

        public List<Student> showAllStudents()
        {
            return studentRepo.findAll();
        }

        public Student createStudent(Student student) {
            if(student.getCourse() < 1 || student.getCourse() > 4)
                throw new IllegalArgumentException("incorrect course");

            if(studentRepo.findByRoom(student.getRoom()).isPresent())
                throw new IllegalArgumentException("one student already live in this room");

            if(student.getName().length() <= 1 || student.getName().contains("1")) throw new IllegalArgumentException("strange name");

            return studentRepo.save(student);
        }


        public void deleteStudent(Long studentId) {
            if(studentRepo.findById(studentId).isEmpty())throw new IllegalArgumentException("students does not exists");

            studentRepo.deleteById(studentId);
        }

        public void updateStudent(Long studentId, String room, Integer course, String name, String sureName) {
            Student student = studentRepo.findById(studentId).orElseThrow();
            if(!(room == null)) student.setRoom(room);
            if(course != null) student.setCourse(course);
            if(!(name == null)) student.setName(name);
            if(!(sureName == null)) student.setSureName(sureName);

            studentRepo.save(student);
        }
    }




