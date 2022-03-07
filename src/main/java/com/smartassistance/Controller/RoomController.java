package com.smartassistance.Controller;

import com.smartassistance.Model.Room;
import com.smartassistance.Service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/smart-assistance/api")
public class RoomController {

    private final RoomService roomService;

    private final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add-room")
    public ResponseEntity addNewRoom(@RequestBody Room room) {

        logger.info("Request To Add New Room");

        Room newRoom = roomService.addNewRoom(room);

        if (newRoom == null) {
            return new ResponseEntity<>("The Room is already Exist in the DB", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
    }

    @PutMapping("/update-room/{id}")
    public ResponseEntity updateExistRoom(@RequestBody Room room, @PathVariable("id") Long roomId) {

        logger.info("Request To update Existing Room");

        Room existRoom = roomService.updateExistRoom(room, roomId);

        if (existRoom == null) {
            return new ResponseEntity<>("Couldn't Find a room with given ID", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(existRoom, HttpStatus.OK);
    }

    @GetMapping("/room-details/{id}")
    public ResponseEntity retrieveRoomDetails(@PathVariable("id") Long roomId) {

        logger.info("Request To Retrieve Room Details");

        Room room = roomService.retrieveRoomDetails(roomId);

        if (room == null) {
            return new ResponseEntity<>("Couldn't Find a room with given ID", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @DeleteMapping("/delete-room/{id}")
    public ResponseEntity deleteExistingRoom(@PathVariable("id") Long roomId) {

        logger.info("Request To Delete a Room");

        boolean result = roomService.deleteRoom(roomId);

        if (!result) {
            return new ResponseEntity<>("Couldn't Find a room with given ID", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>("The had Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping("/all-rooms")
    public ResponseEntity retrieveAllRooms() {
        List<Room> rooms = roomService.retrieveAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }
}
