package timetable.servlet.teacher;

import timetable.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListOfTeachersServlet", urlPatterns = {"/listOfTeachers"})
public class ListOfTeachersServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        request.setAttribute("teachers", teacherService.getAllTeachers());
        request.getRequestDispatcher("jsp/teacher/listOfTeachers.jsp").forward(request, response);
    }
}
