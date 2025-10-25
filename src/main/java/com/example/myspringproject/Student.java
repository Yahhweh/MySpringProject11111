package com.example.myspringproject;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sureName;
    private Integer course;
    private String room;


    public Student(String name, String sureName, Integer course, String room) {
        this.name = name;
        this.sureName = sureName;
        this.course = course;
        this.room = room;
    }

    public Student() {

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public Integer getCourse() {
        return course;
    }

    public String getRoom() {
        return room;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
