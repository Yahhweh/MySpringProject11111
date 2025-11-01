package com.example.myspringproject.Repo;

import com.example.myspringproject.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepo extends JpaRepository<Room, Long> {

    Optional<Room> findRoomByRoomNumber(String number);
}
