package timetable.servlet.room;

import timetable.service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListOfRoomsServlet", urlPatterns = {"/listOfRooms"})
public class ListOfRoomsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomService roomService = new RoomService();
        request.setAttribute("rooms", roomService.getAllRooms());
        request.getRequestDispatcher("jsp/room/listOfRooms.jsp").forward(request, response);
    }
}
