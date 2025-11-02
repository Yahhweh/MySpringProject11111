package com.example.myspringproject.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RoomRequestDTO {

        @Column(unique = true)
        private String roomNumber;


        public RoomRequestDTO(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public RoomRequestDTO() {}
    }
