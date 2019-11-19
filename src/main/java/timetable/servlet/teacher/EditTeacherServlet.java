package timetable.servlet.teacher;

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

@WebServlet(name = "EditTeacherServlet", urlPatterns = {"/editTeacher"})
public class EditTeacherServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        Teacher teacher = new Teacher();
        teacher.setId(Long.valueOf(request.getParameter("id")));
        teacher.setFirstName(request.getParameter("firstName"));
        teacher.setLastName(request.getParameter("lastName"));
        teacher.setPosition(request.getParameter("position"));
        boolean isTeacherUpdated = teacherService.updateTeacher(teacher);
        if (isTeacherUpdated) {
            request.getSession().setAttribute("teacher", teacher);
            List<Teacher> teachers = teacherService.getAllTeachers();
            request.setAttribute("teachers", teachers);
            request.getRequestDispatcher("jsp/teacher/listOfTeachers.jsp").forward(request, response);
        } else {
            request.setAttribute("error", TEACHER_EXISTS);
            request.getRequestDispatcher("jsp/teacher/editTeacher.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TeacherService teacherService = new TeacherService();
        Long id = Long.valueOf(request.getParameter("id"));
        Teacher teacher = teacherService.findTeacherById(id);
        request.setAttribute("teacher", teacher);
        request.getRequestDispatcher("jsp/teacher/editTeacher.jsp").forward(request, response);
    }
}
