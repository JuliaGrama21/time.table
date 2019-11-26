package timetable.dao;

import timetable.model.Room;

import java.util.List;

public interface IRoomDao {

    boolean addRoom(Room room);

    boolean updateRoom(Room room);

    boolean deleteRoom(Long id);

    Room findRoomById(Long id);

    List<Room> getAllRooms();
}
