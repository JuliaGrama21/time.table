package timetable.servlet.teacher;

import timetable.constant.ErrorConstants;
import timetable.model.Teacher;
import timetable.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static timetable.constant.ErrorConstants.TEACHER_EXISTS;

@WebServlet(name = "AddTeacherServlet", urlPatterns = {"/addTeacher"})
public class AddTeacherServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Teacher teacher = new Teacher();
        TeacherService teacherService = new TeacherService();
        teacher.setFirstName(request.getParameter("firstName"));
        teacher.setLastName(request.getParameter("lastName"));
        teacher.setPosition(request.getParameter("position"));
        request.getSession().setAttribute("teacher", teacher);
        boolean isTeacherAdded = teacherService.addTeacher(teacher);
        if (isTeacherAdded) {
            List<Teacher> teachers = teacherService.getAllTeachers();
            request.setAttribute("teachers", teachers);
            request.getRequestDispatcher("jsp/teacher/listOfTeachers.jsp").forward(request, response);
        } else {
            request.setAttribute("error", TEACHER_EXISTS);
            request.getRequestDispatcher("jsp/teacher/addTeacher.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        List<Teacher> teachers = teacherService.getAllTeachers();
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("jsp/teacher/addTeacher.jsp").forward(request, response);
    }
}
