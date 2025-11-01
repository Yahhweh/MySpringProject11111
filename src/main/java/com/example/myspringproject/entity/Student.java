package com.example.myspringproject.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 20, message = "name length must be from 2 to 20 letters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "name must contain only letters")
    private String name;
    @Size(min = 2, max = 20, message = "sureName length must be from 2 to 20 letters")
    @Pattern(regexp = "^[A-Za-z]+$", message = "sureName must contain only letters")
    private String sureName;
    @Min(1)
    @Max(4)
    private Integer year;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "room_id")
    private Room room;

    public Student(String name, String sureName, Integer year, Course course, Room room) {
        this.name = name;
        this.sureName = sureName;

        this.year = year;
        this.course = course;
        this.room = room;
    }

    public Student() {}


    public void setRoom(Room room) {
        this.room = room;
        if (room != null && !room.getStudents().contains(this)) {
            room.getStudents().add(this);
        }
    }
}


