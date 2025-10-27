package com.example.myspringproject.Classes;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String sureName;
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

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getSureName() { return sureName; }
    public Integer getYear() { return year; }
    public Course getCourse() { return course; }
    public Room getRoom() { return room; }  // ← возвращает Room объект

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setSureName(String sureName) { this.sureName = sureName; }
    public void setYear(Integer year) { this.year = year; }
    public void setCourse(Course course) { this.course = course; }
    public void setRoom(Room room) {
        this.room = room;
        if (room != null && !room.getStudents().contains(this)) {
            room.getStudents().add(this);
        }
    }
}


