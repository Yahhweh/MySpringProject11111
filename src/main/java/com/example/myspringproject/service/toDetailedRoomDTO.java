package com.example.myspringproject.service;

import com.example.myspringproject.DTO.DetailedRoomDTO;
import com.example.myspringproject.entity.Room;
import com.example.myspringproject.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class toDetailedRoomDTO {
    public static DetailedRoomDTO toDetailedRoomDTOMethod(Room room)
    {
        DetailedRoomDTO detailedRoomDTO = new DetailedRoomDTO();
        detailedRoomDTO.setRoomNumber(room.getRoomNumber());
        List<String> studentList = new ArrayList<>();

        for(Student student: room.getStudents())
        {
            studentList.add(student.getName() + " " + student.getSureName());
        }
        int capacity = 0;
        for(int i = 0; i < studentList.size(); i++)
        {
            capacity++;
        }
        detailedRoomDTO.setCapacity(capacity);
        detailedRoomDTO.setStudents(studentList);
        return detailedRoomDTO;
    }
}
