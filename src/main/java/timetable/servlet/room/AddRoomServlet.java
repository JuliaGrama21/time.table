package timetable.servlet.room;

import timetable.constant.ErrorConstants;
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

@WebServlet(name = "AddRoomServlet", urlPatterns = {"/addRoom"})
public class AddRoomServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Room room = new Room();
        RoomService roomService = new RoomService();
        room.setNumber(Integer.parseInt(request.getParameter("number")));
        room.setRoomType(RoomType.valueOf(request.getParameter("roomType")));
        request.getSession().setAttribute("room", room);
        boolean isRoomAdded = roomService.addRoom(room);
        if (isRoomAdded) {
            List<Room> rooms = roomService.getAllRooms();
            request.setAttribute("rooms", rooms);
            request.getRequestDispatcher("jsp/room/listOfRooms.jsp").forward(request, response);
        } else {
            request.setAttribute("error", ROOM_EXISTS);
            request.getRequestDispatcher("jsp/room/addRoom.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        List<Room> rooms = roomService.getAllRooms();
        request.setAttribute("rooms", rooms);
        request.getRequestDispatcher("jsp/room/addRoom.jsp").forward(request, response);
    }
}
