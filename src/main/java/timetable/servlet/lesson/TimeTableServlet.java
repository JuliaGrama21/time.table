package timetable.servlet.lesson;

import timetable.model.*;
import timetable.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TimeTableServlet", urlPatterns = {"/timeTable"})
public class TimeTableServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LessonService lessonService = new LessonService();
        List<Lesson> lessons = lessonService.getAllLessons();
        request.setAttribute("lessons", lessons);
        request.getRequestDispatcher("jsp/lesson/timeTable.jsp").forward(request, response);
    }
}