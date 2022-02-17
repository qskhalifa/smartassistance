package com.smartassistance.Repo;

import com.smartassistance.Model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
    Room findRoomByName(String name);
}
