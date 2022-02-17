package com.smartassistance.ServiceImpl;

import com.smartassistance.Model.Room;
import com.smartassistance.Repo.RoomRepository;
import com.smartassistance.Service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room addNewRoom(Room room) {
        // Check if the room already Exist in the DB
        Room existRoom = roomRepository.findRoomByName(room.getName());

        if (existRoom == null) {
            return roomRepository.save(room);
        }
        return null;
    }

    @Override
    public Room updateExistRoom(Room room, Long roomId) {
        //Check if there is room with the given ID in the DB
        Room existRoom = roomRepository.findById(roomId).orElse(null);

        if (existRoom != null) {
            existRoom.setName(room.getName());
            existRoom.setCapacity(room.getCapacity());
            return existRoom;
        }
        return null;
    }

    @Override
    public Room retrieveRoomDetails(Long roomId) {

        return roomRepository.findById(roomId).orElse(null);
    }

    @Override
    public List<Room> retrieveAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public boolean deleteRoom(Long roomId) {
        // Check if there is room with the given id in the DB
        Room existRoom = roomRepository.findById(roomId).orElse(null);

        if (existRoom != null) {
            roomRepository.delete(existRoom);
            return true;
        }
        return false;
    }
}
