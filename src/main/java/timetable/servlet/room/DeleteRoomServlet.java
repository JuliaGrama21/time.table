package timetable.servlet.room;

import timetable.constant.ErrorConstants;
import timetable.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static timetable.constant.ErrorConstants.ROOM_IS_IN_TIMETABLE;

@WebServlet(name = "DeleteRoomServlet", urlPatterns = {"/deleteRoom"})
public class DeleteRoomServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        Long id = Long.valueOf(request.getParameter("id"));
        boolean isRoomDeleted = roomService.deleteRoom(id);
        if (isRoomDeleted) {
            request.getRequestDispatcher("jsp/room/listOfRooms.jsp").forward(request, response);
        } else {
            request.setAttribute("error", ROOM_IS_IN_TIMETABLE);
            request.getRequestDispatcher("jsp/room/listOfRooms.jsp").forward(request, response);
        }
    }
}
