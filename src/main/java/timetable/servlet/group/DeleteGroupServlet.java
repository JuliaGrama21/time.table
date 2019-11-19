package timetable.servlet.group;

import timetable.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static timetable.constant.ErrorConstants.GROUP_IS_IN_TIMETABLE;

@WebServlet(name = "DeleteGroupServlet", urlPatterns = {"/deleteGroup"})
public class DeleteGroupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupService groupService = new GroupService();
        Long id = Long.valueOf(request.getParameter("id"));
        boolean isGroupDeleted = groupService.deleteGroup(id);
        if (isGroupDeleted) {
            request.getRequestDispatcher("jsp/group/listOfGroups.jsp").forward(request, response);
        } else {
            request.setAttribute("error", GROUP_IS_IN_TIMETABLE);
            request.getRequestDispatcher("jsp/group/listOfGroups.jsp").forward(request, response);
        }
    }
}
