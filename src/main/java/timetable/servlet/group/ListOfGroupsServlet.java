package timetable.servlet.group;

import timetable.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListOfGroupsServlet", urlPatterns = {"/listOfGroups"})
public class ListOfGroupsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupService groupService = new GroupService();
        request.setAttribute("groups", groupService.getAllGroups());
        request.getRequestDispatcher("jsp/group/listOfGroups.jsp").forward(request, response);
    }
}
