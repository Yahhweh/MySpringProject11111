package com.example.myspringproject.Classes;

public class CourseShortDTO {

    private Long id;
    private String name;
    private Integer capacity;

    public CourseShortDTO(Long id, String name, Integer capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public CourseShortDTO( String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
