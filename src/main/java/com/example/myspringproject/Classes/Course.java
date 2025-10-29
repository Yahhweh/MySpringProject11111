    package com.example.myspringproject.Classes;

    import jakarta.persistence.*;

    import java.util.List;

    @Entity

    public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String name;
        @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        List<Student> students;
        Integer capacity;


        public Course(String name, Integer capacity){
            this.name = name;
            this.capacity = capacity;
        }

        public Course() {
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Student> getStudents() {
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

        public void setStudents(List<Student> students) {
            this.students = students;
        }

        public void setCapacity(Integer capacity) {
            this.capacity = capacity;
        }
    }
