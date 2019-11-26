package timetable.service;

import timetable.dao.HibernateRoomDao;
import timetable.dao.RoomDao;
import timetable.model.Room;

import java.util.List;

public class RoomService {

    private RoomDao roomDaoo = new RoomDao();
    private HibernateRoomDao roomDao = new HibernateRoomDao();

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
        return roomDaoo.getRoomIdByNumber(number);
    }

    public Room findRoomById(Long roomId) {
        return roomDao.findRoomById(roomId);
    }

    public List<Room> getAllRooms() {
        return roomDao.getAllRooms();
    }

    public boolean checkRoom(Room room) {
        return roomDaoo.checkRoom(room);
    }

}


