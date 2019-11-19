package timetable.servlet.room;

import timetable.model.Room;
import timetable.model.RoomType;
import timetable.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static timetable.constant.ErrorConstants.ROOM_EXISTS;

@WebServlet(name = "EditRoomServlet", urlPatterns = {"/editRoom"})
public class EditRoomServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        Room room = new Room();
        room.setId(Long.valueOf(request.getParameter("id")));
        room.setNumber(Integer.parseInt(request.getParameter("number")));
        room.setRoomType(RoomType.valueOf(request.getParameter("roomType")));
        boolean isRoomUpdated = roomService.updateRoom(room);
        if (isRoomUpdated) {
            request.getSession().setAttribute("room", room);
            List<Room> rooms = roomService.getAllRooms();
            request.setAttribute("rooms", rooms);
            request.getRequestDispatcher("jsp/room/listOfRooms.jsp").forward(request, response);
        } else {
            request.setAttribute("error", ROOM_EXISTS);
            request.getRequestDispatcher("jsp/room/editRoom.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        Long id = Long.valueOf(request.getParameter("id"));
        Room room = roomService.findRoomById(id);
        request.setAttribute("room", room);
        request.getRequestDispatcher("jsp/room/editRoom.jsp").forward(request, response);
    }


}
