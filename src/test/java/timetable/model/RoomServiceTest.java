package timetable.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import timetable.dao.RoomDao;
import timetable.service.RoomService;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RoomServiceTest {

    @Mock
    RoomDao roomDao;

    @InjectMocks
    RoomService roomService = new RoomService();

    @Test
    public void addRoomTest() {
        Room room = new Room();
        room.setId(5L);
        room.setNumber(145);
        room.setRoomType(RoomType.LECTURE_ROOM);
        when(roomDao.addRoom(room)).thenReturn(true);
        boolean isAdded = roomService.addRoom(room);
        assertEquals(true, isAdded);
    }

    @Test
    public void deleteRoomTest() {
        Room room = new Room();
        room.setId(5L);
        when(roomDao.deleteRoom(room.getId())).thenReturn(true);
        boolean isDeleted = roomService.deleteRoom(room.getId());
        assertEquals(true, isDeleted);
    }

    @Test
    public void updateRoomTest() {
        Room room1 = new Room();
        room1.setId(5L);
        room1.setNumber(246);
        room1.setRoomType(RoomType.LABORATORY);
        when(roomDao.updateRoom(room1)).thenReturn(true);
        boolean isUpdated = roomService.updateRoom(room1);
        assertEquals(true, isUpdated);
    }

    @Test
    public void getRoomIdByNumberTest() {
        Room room1 = new Room();
        room1.setId(5L);
        room1.setNumber(246);
        Long id1 = room1.getId();
        when(roomDao.getRoomIdByNumber(room1.getNumber())).thenReturn(id1);
        Long id = roomService.getRoomIdByNumber(room1.getNumber());
        assertEquals(id1, id);
    }

    @Test
    public void findRoomByIdTest() {
        Room room1 = new Room();
        room1.setId(5L);
        room1.setNumber(246);
        room1.setRoomType(RoomType.LABORATORY);
        when(roomDao.findRoomById(room1.getId())).thenReturn(room1);
        Room room = roomService.findRoomById(room1.getId());
        assertEquals(room1, room);
    }

    @Test
    public void checkRoomTest() {
        Room room1 = new Room();
        room1.setId(5L);
        room1.setNumber(246);
        room1.setRoomType(RoomType.LABORATORY);
        when(roomDao.checkRoom(room1)).thenReturn(false);
        boolean isFree = roomService.checkRoom(room1);
        assertEquals(false, isFree);
    }


}