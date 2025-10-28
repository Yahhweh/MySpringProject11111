package com.example.myspringproject.Controller;

import com.example.myspringproject.Classes.Course;
import com.example.myspringproject.Classes.CourseResponseDTO;
import com.example.myspringproject.Classes.CourseShortDTO;
import com.example.myspringproject.Repo.CourseRepo;
import com.example.myspringproject.StudentServicePackage.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    CourseService courseService;


    public CourseController(CourseService courseService, CourseRepo courseRepo) {
        this.courseService = courseService;
    }

    @GetMapping("/courses")
    public List<CourseShortDTO> getAllCourses()
    {
        return courseService.getAllCoursesDto();
    }

    @GetMapping("/courses/full")
    public List<CourseResponseDTO> getAllCoursesPlusInfo()
    {
        return courseService.getAllCoursesPlusInfo();
    }

    @PostMapping("/courses")
    public Course postCourse(@RequestBody CourseShortDTO course)
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
