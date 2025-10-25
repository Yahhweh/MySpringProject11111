    package com.example.myspringproject.StudentServicePackage;

    import com.example.myspringproject.Student;
    import com.example.myspringproject.StudentRepo;
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



            if(!validationOfData.checkValidationOfName(student.getName())) throw new IllegalArgumentException("name should has only letters");
            if(!validationOfData.checkValidationOfName(student.getSureName())) throw new IllegalArgumentException("sureName should has only letters");

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
            if(!(name == null))
            {
                if(!validationOfData.checkValidationOfName(name)) throw new IllegalArgumentException("name should has only letters");
                student.setName(name);
            }
            if(!(sureName == null))
                if(!validationOfData.checkValidationOfName(sureName)) throw new IllegalArgumentException("sureName should has only letters");
                student.setSureName(sureName);



            studentRepo.save(student);
        }
    }




