package timetable.servlet.lesson;

import timetable.model.Group;
import timetable.model.Lesson;
import timetable.model.Room;
import timetable.model.Teacher;
import timetable.service.GroupService;
import timetable.service.LessonService;
import timetable.service.RoomService;
import timetable.service.TeacherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LessonsServlet", urlPatterns = {"/lessons"})
public class LessonsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LessonService lessonService = new LessonService();
        List<Lesson> lessons = null;
        String teacherId = request.getParameter("teacherId");
        String roomId = request.getParameter("roomId");
        String groupId = request.getParameter("groupId");
        if (teacherId != null) {
            lessons = lessonService.getLessonsByTeacher(Long.valueOf(teacherId));
            request.setAttribute("teacherId", teacherId);
            TeacherService teacherService = new TeacherService();
            Teacher teacherById = teacherService.findTeacherById(Long.valueOf(teacherId));
            String name = teacherById.getName();
            request.setAttribute("title", name);
        }
        if (roomId != null) {
            lessons = lessonService.getLessonsByRoom(Long.valueOf(roomId));
            request.setAttribute("roomId", roomId);
            RoomService roomService = new RoomService();
            Room roomById = roomService.findRoomById(Long.valueOf(roomId));
            int number = roomById.getNumber();
            request.setAttribute("title", number);
        }
        if (groupId != null) {
            lessons = lessonService.getLessonsByGroup(Long.valueOf(groupId));
            request.setAttribute("groupId", groupId);
            GroupService groupService = new GroupService();
            Group groupById = groupService.findGroupById(Long.valueOf(groupId));
            int number = groupById.getNumber();
            request.setAttribute("title", number);
        }
        request.setAttribute("lessons", lessons);
        request.getRequestDispatcher("jsp/lesson/lessons.jsp").forward(request, response);
    }
}
