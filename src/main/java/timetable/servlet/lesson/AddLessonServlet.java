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

import static timetable.constant.ErrorConstants.LESSON_EXISTS;

@WebServlet(name = "AddLessonServlet", urlPatterns = {"/addLesson"})
public class AddLessonServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Lesson lesson = new Lesson();
        LessonService lessonService = new LessonService();
        TeacherService teacherService = new TeacherService();
        RoomService roomService = new RoomService();
        GroupService groupService = new GroupService();
        SubjectService subjectService = new SubjectService();

        lesson.setTimeSlot(TimeSlot.valueOf(request.getParameter("timeSlot")));

        String subjectName = request.getParameter("subject");
        Long subjectId = subjectService.getSubjectIdByName(subjectName);
        Subject subject = subjectService.findSubjectById(subjectId);
        lesson.setSubject(subject);

        String teacherId = request.getParameter("teacherId");
        Teacher teacher = teacherService.findTeacherById(Long.valueOf(teacherId));
        lesson.setTeacher(teacher);

        String roomNumber = request.getParameter("roomNumber");
        Long roomId = roomService.getRoomIdByNumber(Integer.parseInt(roomNumber));
        Room room = roomService.findRoomById(roomId);
        lesson.setRoom(room);

        String groupNumber = request.getParameter("groupNumber");
        Long groupId = groupService.getGroupIdByNumber(Integer.parseInt(groupNumber));
        Group group = groupService.findGroupById(groupId);
        lesson.setGroup(group);

        lesson.setLessonType(LessonType.valueOf(request.getParameter("lessonType")));

        lesson.setDay(Day.valueOf(request.getParameter("day")));

        boolean isLessonAdded = lessonService.addLesson(lesson);
        if (isLessonAdded) {
            request.setAttribute("lessons", lessonService.getAllLessons());
            request.getRequestDispatcher("jsp/lesson/timeTable.jsp").forward(request, response);
        } else {
            request.setAttribute("error", LESSON_EXISTS);
            request.getRequestDispatcher("jsp/lesson/addLesson.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupService groupService = new GroupService();
        List<Group> groups = groupService.getAllGroups();
        request.setAttribute("groups", groups);

        RoomService roomService = new RoomService();
        List<Room> rooms = roomService.getAllRooms();
        request.setAttribute("rooms", rooms);

        SubjectService subjectService = new SubjectService();
        List<Subject> subjects = subjectService.getAllSubjects();
        request.setAttribute("subjects", subjects);

        TeacherService teacherService = new TeacherService();
        List<Teacher> teachers = teacherService.getAllTeachers();
        request.setAttribute("teachers", teachers);

        request.getRequestDispatcher("jsp/lesson/addLesson.jsp").forward(request, response);
    }
}
