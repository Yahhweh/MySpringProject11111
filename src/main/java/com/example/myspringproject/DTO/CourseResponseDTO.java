    package com.example.myspringproject.DTO;

    import jakarta.persistence.*;
    import lombok.Data;

    import java.util.List;

@Data
    public class CourseResponseDTO {

        String name;

        List<StudentResponseDTO> students;
        Integer capacity;


        public CourseResponseDTO(String name, Integer capacity, List<StudentResponseDTO> students){
            this.name = name;
            this.capacity = capacity;
            this.students = students;
        }

        public CourseResponseDTO() {
        }

    }
