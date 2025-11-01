package com.example.myspringproject.Controller;

import com.example.myspringproject.DTO.DetailedRoomDTO;
import com.example.myspringproject.entity.Room;
import com.example.myspringproject.Repo.RoomRepo;
import com.example.myspringproject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api")
@RestController
public class RoomController {

    RoomRepo roomRepo;
    RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService, RoomRepo roomRepo) {
        this.roomService = roomService;
        this.roomRepo = roomRepo;
    }

    @GetMapping("/rooms")
    public List<Room> getRooms()
    {
        return  roomService.getAllRooms();
    }

    @GetMapping("/rooms/detailed")
    public List<DetailedRoomDTO> getDetailedRooms()
    {
        return  roomService.getAllDetailedRooms();
    }

    @PostMapping("/rooms")
    public Room createRoom(@RequestBody Room room)
    {
        return roomService.createRoom(room);
    }

    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable Long id)
    {
        roomService.deleteRoom(id);
    }

    @PutMapping("/rooms/put/{id}")
    public void updateRoom(@PathVariable Long id,
    @RequestParam(value = "roomNumber", required = false) String roomNumber,
                           @RequestParam(value = "capacity", required = false ) String capacity)
    {
        roomService.updateRoom(id, roomNumber, capacity);
    }

}
