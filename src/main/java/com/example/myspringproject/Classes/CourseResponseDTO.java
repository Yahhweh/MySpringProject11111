    package com.example.myspringproject.Classes;

    import jakarta.persistence.*;

    import java.util.List;


    public class CourseResponseDTO {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
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

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<StudentResponseDTO> getStudents() {
            return students;
        }

        public Integer getCapacity() {
            return capacity;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setStudents(List<StudentResponseDTO> students) {
            this.students = students;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }
    }
