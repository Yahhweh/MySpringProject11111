package com.example.myspringproject.DTO;

import lombok.Data;

@Data
public class StudentRequestDTO {

    private String name;
    private String sureName;

    private Integer year;
    private String course;
    private String room;

    public StudentRequestDTO(String name, String sureName, Integer year, String course, String room) {
        this.name = name;
        this.sureName = sureName;
        this.year = year;
        this.course = course;
        this.room = room;
    }

    public StudentRequestDTO() {
    }
}