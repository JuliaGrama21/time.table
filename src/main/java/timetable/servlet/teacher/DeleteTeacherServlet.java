package timetable.servlet.teacher;

import timetable.constant.ErrorConstants;
import timetable.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteTeacherServlet", urlPatterns = {"/deleteTeacher"})
public class DeleteTeacherServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        Long id = Long.valueOf(request.getParameter("id"));
        boolean isTeacherDeleted = teacherService.deleteTeacher(id);
        if (isTeacherDeleted) {
            request.getRequestDispatcher("jsp/teacher/listOfTeachers.jsp").forward(request, response);
        } else {
            request.setAttribute("error", ErrorConstants.TEACHER_IS_IN_TIMETABLE);
            request.getRequestDispatcher("jsp/teacher/listOfTeachers.jsp").forward(request, response);
        }
    }
}
