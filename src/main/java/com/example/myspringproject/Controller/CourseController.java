package com.example.myspringproject.Controller;

import com.example.myspringproject.entity.Course;
import com.example.myspringproject.DTO.CourseRequestDTO;
import com.example.myspringproject.DTO.CourseResponseDTO;
import com.example.myspringproject.Repo.CourseRepo;
import com.example.myspringproject.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class CourseController {

    CourseService courseService;


    public CourseController(CourseService courseService, CourseRepo courseRepo) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<CourseRequestDTO> getAllCourses()
    {
        return courseService.getAllCoursesDto();
    }

//    @GetMapping("/courses/detailed")
//    public List<CourseResponseDTO> getAllCoursesPlusInfo()
//    {
//        return courseService.getAllCoursesPlusInfo();
//    }

    @PostMapping("/courses")
    public Course postCourse(@RequestBody CourseRequestDTO course)
    {
        return  courseService.postCourse(course);
    }

    @PutMapping("/courses/put/{CourseId}")
    public Course UpdateCourse(@RequestParam Long id,
    @PathVariable(value="name", required = false) String name)
    {
        return courseService.updateCourse(id, name);
    }

}
