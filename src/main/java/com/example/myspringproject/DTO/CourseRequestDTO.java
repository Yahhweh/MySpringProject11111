package com.example.myspringproject.DTO;

import lombok.Data;

@Data

public class CourseRequestDTO {


        private String name;
        private Integer capacity;

        public CourseRequestDTO(String name, Integer capacity) {
            this.name = name;
            this.capacity = capacity;
        }

    public CourseRequestDTO() {
    }
}
