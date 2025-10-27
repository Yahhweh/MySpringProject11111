package com.example.myspringproject.StudentServicePackage;

import com.example.myspringproject.Classes.Room;
import com.example.myspringproject.Repo.RoomRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepo roomRepo;


    public RoomService(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    public List<Room> getAllRooms()
    {
        return roomRepo.findAll();
    }

    public Room createRoom(Room room) {
        if(roomRepo.findRoomByRoomNumber(room.getRoomNumber()).isPresent()) throw new IllegalArgumentException("this room already exists");

        roomRepo.save(room);
        return room;
    }

    public void deleteRoom(Long id) {
        if(roomRepo.findById(id).isEmpty()) throw new IllegalArgumentException("room does not exists");

        Room room = roomRepo.findById(id).orElseThrow();
        roomRepo.delete(room);

    }

    @Transactional
    public void updateRoom(Long id, String roomNumber, String capacity) {
        Room room = roomRepo.findById(id).orElseThrow();
        if(roomNumber != null)
        {
            room.setRoomNumber(roomNumber);
        }
        if(Integer.parseInt(capacity) != 0)
        {
            room.setCapacity(Integer.parseInt(capacity) );
        }
        roomRepo.save(room);
    }
}
