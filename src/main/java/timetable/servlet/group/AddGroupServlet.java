package timetable.servlet.group;

import timetable.model.Group;
import timetable.service.GroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static timetable.constant.ErrorConstants.GROUP_EXISTS;

@WebServlet(name = "AddGroupServlet", urlPatterns = {"/addGroup"})
public class AddGroupServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Group group = new Group();
        GroupService groupService = new GroupService();
        group.setNumber(Integer.parseInt(request.getParameter("number")));
        group.setName(request.getParameter("name"));
        request.getSession().setAttribute("group", group);
        boolean isGroupAdded = groupService.addGroup(group);
        if (isGroupAdded) {
            List<Group> groups = groupService.getAllGroups();
            request.setAttribute("groups", groups);
            request.getRequestDispatcher("jsp/group/listOfGroups.jsp").forward(request, response);
        } else {
            request.setAttribute("error", GROUP_EXISTS);
            request.getRequestDispatcher("jsp/group/addGroup.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupService groupService = new GroupService();
        List<Group> groups = groupService.getAllGroups();
        request.setAttribute("groups", groups);
        request.getRequestDispatcher("jsp/group/addGroup.jsp").forward(request, response);
    }
}

