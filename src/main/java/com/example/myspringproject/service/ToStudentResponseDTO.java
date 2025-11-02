package com.example.myspringproject.service;

import com.example.myspringproject.DTO.CourseRequestDTO;
import com.example.myspringproject.DTO.RoomRequestDTO;
import com.example.myspringproject.DTO.StudentResponseDTO;
import com.example.myspringproject.entity.Student;

 class ToStudentResponseDTO {
    public static StudentResponseDTO toStudentResponseDTOMethod(Student student) {
        CourseRequestDTO courseRequestDTO = new CourseRequestDTO();
        courseRequestDTO.setName(student.getCourse().getName());
        courseRequestDTO.setCapacity(student.getCourse().getCapacity());

        RoomRequestDTO roomRequestDTO = new RoomRequestDTO();
        roomRequestDTO.setRoomNumber(student.getRoom().getRoomNumber());

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(
                student.getName(),
                student.getSureName(),
                student.getYear(),
                courseRequestDTO,
                roomRequestDTO
        );

        return studentResponseDTO;
    }
}