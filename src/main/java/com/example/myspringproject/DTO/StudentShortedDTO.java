package com.example.myspringproject.DTO;

import lombok.Data;

@Data
public class StudentShortedDTO {
        private String name;
        private String sureName;
        private String room;

        public StudentShortedDTO(String name, String sureName, String room) {
            this.name = name;
            this.sureName = sureName;
            this.room =room;
        }

    public StudentShortedDTO() {
    }
}


