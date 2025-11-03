package com.example.myspringproject.service;

import com.example.myspringproject.DTO.CourseRequestDTO;
import com.example.myspringproject.DTO.CourseResponseDTO;
import com.example.myspringproject.DTO.RoomRequestDTO;
import com.example.myspringproject.DTO.StudentResponseDTO;
import com.example.myspringproject.Repo.CourseRepo;
import com.example.myspringproject.Repo.StudentRepo;
import com.example.myspringproject.entity.Course;
import com.example.myspringproject.entity.Room;
import com.example.myspringproject.entity.Student;
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


    public CourseRequestDTO toDto(Course course) {
        return new CourseRequestDTO(course.getName(), course.getCapacity());
    }

    public RoomRequestDTO toRoomRequestDTO(Student student)
    {
        Room commonRoom = student.getRoom();
        return new RoomRequestDTO(commonRoom.getRoomNumber());
    }




    public List<CourseRequestDTO> getAllCoursesDto() {
        List<Course> courses = courseRepo.findAll();
        List<CourseRequestDTO> courseDTOs = new ArrayList<>();

        for (Course course : courses) {
            CourseRequestDTO dto = toDto(course);
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
                    students.add(ToStudentResponseDTO.toStudentResponseDTOMethod(student));
                }
            }

            CourseResponseDTO dto = new CourseResponseDTO();
            dto.setName(course.getName());
            dto.setCapacity(course.getCapacity());
            dto.setStudents(students);

            responseCourses.add(dto);
        }

        return responseCourses;
    }

    public Course postCourse(CourseRequestDTO course) {
        if(courseRepo.findByName(course.getName()).isPresent()) throw  new IllegalArgumentException("course exists");
        Course course1 = new Course();
        course1.setName(course.getName());
        course1.setCapacity(0);
        course1.setStudents(List.of());

        return courseRepo.save(course1);
    }
}
