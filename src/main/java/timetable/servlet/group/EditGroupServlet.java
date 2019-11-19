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

@WebServlet(name = "EditGroupServlet", urlPatterns = {"/editGroup"})
public class EditGroupServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupService groupService = new GroupService();
        Group group = new Group();
        group.setId(Long.valueOf(request.getParameter("id")));
        group.setNumber(Integer.parseInt(request.getParameter("number")));
        group.setName(request.getParameter("name"));
        boolean isUpdatedGroup = groupService.updateGroup(group);
        if (isUpdatedGroup) {
            request.getSession().setAttribute("group", group);
            List<Group> groups = groupService.getAllGroups();
            request.setAttribute("groups", groups);
            request.getRequestDispatcher("jsp/group/listOfGroups.jsp").forward(request, response);
        } else {
            request.setAttribute("error", GROUP_EXISTS);
            request.getRequestDispatcher("jsp/group/editGroup.jsp").forward(request, response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupService groupService = new GroupService();
        Long id = Long.valueOf(request.getParameter("id"));
        Group group = groupService.findGroupById(id);
        request.setAttribute("group", group);
        request.getRequestDispatcher("jsp/group/editGroup.jsp").forward(request, response);
    }
}
