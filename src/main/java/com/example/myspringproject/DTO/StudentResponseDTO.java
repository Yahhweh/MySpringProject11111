package com.example.myspringproject.DTO;

import lombok.Data;

@Data
public class StudentResponseDTO {
    private String name;
    private String sureName;
    private Integer year;
    private CourseRequestDTO course;
    private RoomRequestDTO room;

    public StudentResponseDTO(String name, String sureName, Integer year, CourseRequestDTO course, RoomRequestDTO room) {
        this.name = name;
        this.sureName = sureName;
        this.year = year;
        this.course = course;
        this.room =room;
    }


}



