package timetable.servlet.lesson;

import timetable.model.*;
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

@WebServlet(name = "AddLessonServlet", urlPatterns = {"/addLesson"})
public class AddLessonServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Lesson> lessons = null;
        Lesson lesson = new Lesson();
        LessonService lessonService = new LessonService();
        TeacherService teacherService = new TeacherService();
        RoomService roomService = new RoomService();
        GroupService groupService = new GroupService();
        lesson.setTimeSlot(TimeSlot.valueOf(request.getParameter("timeSlot")));
        lesson.setLessonType(LessonType.valueOf(request.getParameter("lessonType")));
        lesson.setDay(Day.valueOf(request.getParameter("day")));

        String teacherId = request.getParameter("teacherId");
        String roomId = request.getParameter("roomId");
        String groupId = request.getParameter("groupId");

        if (!teacherId.equals("")) {
            Teacher teacher = teacherService.findTeacherById(Long.valueOf(teacherId));
            lesson.setTeacher(teacher);
            Long id = groupService.getGroupIdByNumber(Integer.parseInt(request.getParameter("groupNumber")));
            lesson.setGroup(groupService.findGroupById(id));
            lesson.setRoom(roomService.findRoomById(roomService.getRoomIdByNumber(Integer.parseInt(request.getParameter("roomNumber")))));
            lessonService.addLesson(lesson);
            lessons = lessonService.getLessonsByTeacher(Long.valueOf(teacherId));
            request.setAttribute("teacherId", teacherId);
        }
        if (!groupId.equals("")) {
            Group group = groupService.findGroupById(Long.valueOf(groupId));
            lesson.setGroup(group);
            Long groupTeacherId = teacherService.getTeacherIdByName(request.getParameter("firstName"), request.getParameter("lastName"));
            lesson.setTeacher(teacherService.findTeacherById(groupTeacherId));
            Long id = roomService.getRoomIdByNumber(Integer.parseInt(request.getParameter("roomNumber")));
            lesson.setRoom(roomService.findRoomById(id));
            lessonService.addLesson(lesson);
            lessons = lessonService.getLessonsByGroup(Long.valueOf(groupId));
            request.setAttribute("groupId", groupId);
        }
        if (!roomId.equals("")) {
            Room room = roomService.findRoomById(Long.valueOf(roomId));
            lesson.setRoom(room);
            Long id = groupService.getGroupIdByNumber(Integer.parseInt(request.getParameter("groupNumber")));
            lesson.setGroup(groupService.findGroupById(id));
            Long roomTeacherId = teacherService.getTeacherIdByName(request.getParameter("firstName"), request.getParameter("lastName"));
            lesson.setTeacher(teacherService.findTeacherById(roomTeacherId));
            lessonService.addLesson(lesson);
            lessons = lessonService.getLessonsByRoom(Long.valueOf(roomId));
            request.setAttribute("roomId", roomId);
        }
        request.setAttribute("lessons", lessons);
        request.getRequestDispatcher("jsp/lesson/lessons.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("teacherId", request.getParameter("teacherId"));
        request.setAttribute("roomId", request.getParameter("roomId"));
        request.setAttribute("groupId", request.getParameter("groupId"));
        request.getRequestDispatcher("jsp/lesson/addLesson.jsp").forward(request, response);
    }
}
