package com.example.myspringproject.DTO;

import com.example.myspringproject.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DetailedRoomDTO {
    @Column(unique = true)
    private String roomNumber;

    private Integer capacity;

    private List<String> students = new ArrayList<>();

    public DetailedRoomDTO(String roomNumber, Integer capacity, List<String> students) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.students = students;
    }

    public DetailedRoomDTO() {}
}
