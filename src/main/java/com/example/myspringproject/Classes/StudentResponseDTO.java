package com.example.myspringproject.Classes;

public class StudentResponseDTO {
    private String name;
    private String sureName;
    private Integer year;
    private CourseShortDTO course;
    private Room room;

    public StudentResponseDTO(String name, String sureName, Integer year, CourseShortDTO course, Room room) {
        this.name = name;
        this.sureName = sureName;
        this.year = year;
        this.course = course;
        this.room =room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public StudentResponseDTO() {
    }

    public String getName() {
        return name;
    }

    public String getSureName() {
        return sureName;
    }

    public Integer getYear() {
        return year;
    }

    public CourseShortDTO getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setCourse(CourseShortDTO course) {
        this.course = course;
    }


}



