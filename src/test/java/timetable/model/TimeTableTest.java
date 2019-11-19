package timetable.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class TimeTableTest {

    private TimeTable TIME_TABLE;
    private Set<Lesson> lessonsForRoom;
    private Set<Lesson> lessonsForGroup;
    private Set<Lesson> lessonsForTeacher;
    private Room room106;
    private Teacher teacher;
    private Group group142;

    @Before
    public void setUp() {

        group142 = new Group(3L, 142, "Engineering");
        Group group242 = new Group(4L, 242, "Programming");
        Group group342 = new Group(5L, 342, "Cyber");
        teacher = new Teacher(3L, "Misha", "Chernivchan", "teacher of English");
        Teacher teacher1 = new Teacher(4L, "Sasha", "Ivanovich", "teacher of Programming");
        Teacher teacher2 = new Teacher(5L, "Roman", "Lazar", "teacher of Cyber");
        room106 = new Room(3L, 106, RoomType.LECTURE_ROOM);
        Room room1 = new Room(4L, 306, RoomType.LECTURE_ROOM);
        Subject subject = new Subject(1L, "java");
        Lesson lesson = new Lesson(4L, TimeSlot.FIRST, subject, group142, teacher, room106, LessonType.LECTURE, Day.MONDAY);
        Lesson lesson1 = new Lesson(5L, TimeSlot.FIRST, subject, group242, teacher1, room106, LessonType.LECTURE, Day.WEDNESDAY);
        Lesson lesson2 = new Lesson(6L, TimeSlot.FIRST, subject, group342, teacher2, room1, LessonType.LECTURE, Day.THURSDAY);

        Set<Lesson> lessons = new HashSet<>();
        lessons.add(lesson);
        lessons.add(lesson1);
        lessons.add(lesson2);

        lessonsForRoom = new HashSet<>();
        lessonsForRoom.add(lesson);
        lessonsForRoom.add(lesson1);

        lessonsForGroup = new HashSet<>();
        lessonsForGroup.add(lesson);

        lessonsForTeacher = new HashSet<>();
        lessonsForTeacher.add(lesson);

        TIME_TABLE = new TimeTable(lessons);
    }

    @Test
    public void testAddLesson() {

        Group group = new Group(3L, 142, "Engineering");
        Teacher teacher = new Teacher(3L, "Misha", "Chernivchan", "teacher of English");
        Room room = new Room(3L, 106, RoomType.LECTURE_ROOM);
        Subject subject = new Subject(1L, "java");
        Lesson lesson = new Lesson(4L, TimeSlot.FIRST, subject, group, teacher, room, LessonType.LECTURE, Day.FRIDAY);

        TIME_TABLE.addLesson(lesson);
        assertTrue("", TIME_TABLE.getLessons().contains(lesson));
    }

    @Test
    public void testGetTimeTableForRoom() {

        Set<Lesson> actual = TIME_TABLE.getTimeTableForRoom(room106);
        assertEquals(lessonsForRoom, actual);
    }

    @Test
    public void testGetTimeTableForTeacher() {

        Set<Lesson> actual = TIME_TABLE.getTimeTableForTeacher(teacher);
        assertEquals(lessonsForTeacher, actual);
    }

    @Test
    public void getTimeTableForGroup() {

        Set<Lesson> actual = TIME_TABLE.getTimeTableForGroup(group142);
        assertEquals(lessonsForGroup, actual);
    }
}