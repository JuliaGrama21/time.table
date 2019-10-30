package timetable;

import timetable.model.*;
import timetable.service.JsonService;

public class Application {
    public static void main(String[] args) {
        Group group = new Group(1L, 142, "Engineering");
        Group group1 = new Group(2L, 242, "Programming");

        Teacher teacher = new Teacher(1L, "Mykola", "Igorovych", "Teacher of Java");
        Teacher teacher1 = new Teacher(2L, "Roman", "Romanovych", "teacher of C++");

        Room room = new Room(1L, 106, RoomType.LECTURE_ROOM);
        Room room1 = new Room(2L, 204, RoomType.LABORATORY);

        Lesson lesson = new Lesson(1L, TimeSlot.FIRST, group1, teacher, room, LessonType.LECTURE, Day.MONDAY);
        Lesson lesson1 = new Lesson(2L, TimeSlot.FIRST, group, teacher, room, LessonType.LECTURE, Day.MONDAY);
        Lesson lesson2 = new Lesson(3L, TimeSlot.THIRD, group1, teacher, room, LessonType.LAB, Day.MONDAY);

        TimeTable timeTable = new TimeTable();

        timeTable.addLesson(lesson);
        timeTable.addLesson(lesson1);
        timeTable.addLesson(lesson2);

        timeTable.getTimeTableForTeacher(teacher);
        timeTable.getTimeTableForGroup(group);
        timeTable.getTimeTableForRoom(room);

        JsonService jsonService = new JsonService();
        jsonService.writeTable("DATA.json",timeTable);
        System.out.println("Test : " + jsonService.readTable("DATA.json"));
    }

}


