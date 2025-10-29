package com.example.myspringproject.StudentServicePackage;

import com.example.myspringproject.Classes.*;
import com.example.myspringproject.Repo.CourseRepo;
import com.example.myspringproject.Repo.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    CourseRepo courseRepo;
    StudentRepo studentRepo;

    public CourseService(CourseRepo courseRepo, StudentRepo studentRepo) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    public Course updateCourse(Long id, String name) {
        Course course = courseRepo.findById(id).orElseThrow();
        course.setName(name);
        return courseRepo.save(course);
    }


    public CourseShortDTO toDto(Course course) {
        return new CourseShortDTO(course.getId(), course.getName(), course.getCapacity());
    }

    public StudentResponseDTO toStudentDto(Student student) {
        Course course = student.getCourse();
        CourseShortDTO courseDTO = new CourseShortDTO(course.getId(), course.getName(), course.getCapacity());
        return new StudentResponseDTO(
                student.getName(),
                student.getSureName(),
                student.getYear(),
                courseDTO,
                student.getRoom()
        );
    }



    public List<CourseShortDTO> getAllCoursesDto() {
        List<Course> courses = courseRepo.findAll();
        List<CourseShortDTO> courseDTOs = new ArrayList<>();

        for (Course course : courses) {
            CourseShortDTO dto = toDto(course);
            courseDTOs.add(dto);
        }

        return courseDTOs;
    }



    public List<CourseResponseDTO> getAllCoursesPlusInfo() {
        List<Course> courses = courseRepo.findAll();
        List<CourseResponseDTO> responseCourses = new ArrayList<>();

        for (Course course : courses) {
            List<StudentResponseDTO> students = new ArrayList<>();
            List<Student> courseStudents = course.getStudents();
            if (courseStudents != null) {
                for (Student student : courseStudents) {
                    students.add(toStudentDto(student));
                }
            }

            CourseResponseDTO dto = new CourseResponseDTO();
            dto.setId(course.getId());
            dto.setName(course.getName());
            dto.setCapacity(course.getCapacity());
            dto.setStudents(students);

            responseCourses.add(dto);
        }

        return responseCourses;
    }

    public Course postCourse(CourseShortDTO course) {
        if(courseRepo.findByName(course.getName()).isPresent()) throw  new IllegalArgumentException("course exists");
        Course course1 = new Course();
        course1.setName(course.getName());
        course1.setCapacity(0);
        course1.setStudents(List.of());

        return courseRepo.save(course1);
    }
}
