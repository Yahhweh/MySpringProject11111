package com.example.myspringproject.entity;

public class StudentDTO
{
    private String name;
    private String sureName;
    private Integer year;
    private String course;
    private String room;

    public StudentDTO(String name, String sureName, Integer year, String course, String room) {
        this.name = name;
        this.sureName = sureName;
        this.year = year;
        this.course = course;
        this.room = room;
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

    public String getCourse() {
        return course;
    }

    public String getRoom() {
        return room;
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

    public void setCourse(String course) {
        this.course = course;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}