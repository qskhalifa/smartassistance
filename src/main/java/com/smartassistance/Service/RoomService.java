package com.smartassistance.Service;

import com.smartassistance.Model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
    Room addNewRoom (Room room);
    Room updateExistRoom(Room room, Long roomId);
    Room retrieveRoomDetails(Long roomId);
    List<Room> retrieveAllRooms();
    boolean deleteRoom(Long roomId);

}
