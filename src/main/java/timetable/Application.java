package timetable;

import timetable.dao.LessonDao;
import timetable.model.*;

public class Application {
    public static void main(String[] args) {

        Group group = new Group(1L, 142, "Engineering");
        Group group1 = new Group(2L, 242, "Programming");

        Teacher teacher = new Teacher(1L, "Mykola", "Igorovych", "Teacher of Java");
        Teacher teacher1 = new Teacher(2L, "Roman", "Romanovych", "teacher of C++");
        Teacher teacher2 = new Teacher(3L, "Valera", "Dyakov", "teacher of C#");

        Room room = new Room(1L, 106, RoomType.LECTURE_ROOM);
        Room room1 = new Room(2L, 204, RoomType.LABORATORY);

//        Lesson lesson = new Lesson(1L, TimeSlot.FIRST, group, teacher, room, LessonType.LECTURE, Day.MONDAY);
//        Lesson lesson1 = new Lesson(2L, TimeSlot.SECOND, group1, teacher1, room1, LessonType.LECTURE, Day.MONDAY);
//        Lesson lesson2 = new Lesson(3L, TimeSlot.SECOND, group1, teacher1, room1, LessonType.LAB, Day.MONDAY);

//      JsonService jsonService = new JsonService();
//      jsonService.writeTable("DATA.json",timeTable);
//      System.out.println("Test : " + jsonService.readTable("DATA.json"));

    }
}


