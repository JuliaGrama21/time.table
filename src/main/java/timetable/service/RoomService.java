package timetable.service;

import timetable.dao.RoomDao;
import timetable.model.Room;

import java.util.List;

public class RoomService {

    private RoomDao roomDao = new RoomDao();

    public boolean addRoom(Room room) {
        return roomDao.addRoom(room);
    }

    public boolean deleteRoom(Long id) {
        return roomDao.deleteRoom(id);
    }

    public boolean updateRoom(Room room) {
        return roomDao.updateRoom(room);
    }

    public Long getRoomIdByNumber(int number) {
        return roomDao.getRoomIdByNumber(number);
    }

    public Room findRoomById(Long roomId) {
        return roomDao.findRoomById(roomId);
    }

    public String getRoomTypeByNumber(int number) {
        return roomDao.getRoomTypeByNumber(number);
    }

    public List<Room> getAllRooms() {
        return roomDao.getAllRooms();
    }

}


