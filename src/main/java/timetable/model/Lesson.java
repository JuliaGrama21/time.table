package timetable.model;

import java.util.Objects;

public class Lesson {

    private Long id;
    private TimeSlot timeSlot;
    private Group group;
    private Teacher teacher;
    private Room room;
    private LessonType lessonType;
    private Day day;

    public Lesson() {
    }

    public Lesson(Long id, TimeSlot timeSlot, Group group, Teacher teacher, Room room, LessonType lessonType, Day day) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.group = group;
        this.teacher = teacher;
        this.room = room;
        this.lessonType = lessonType;
        this.day = day;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LessonType getLessonType() {
        return lessonType;
    }

    public void setLessonType(LessonType lessonType) {
        this.lessonType = lessonType;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", timeSlot=" + timeSlot +
                ", group=" + group +
                ", teacher=" + teacher +
                ", room=" + room +
                ", lessonType=" + lessonType +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return Objects.equals(id, lesson.id) &&
                timeSlot == lesson.timeSlot &&
                Objects.equals(group, lesson.group) &&
                Objects.equals(teacher, lesson.teacher) &&
                Objects.equals(room, lesson.room) &&
                lessonType == lesson.lessonType &&
                day == lesson.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeSlot, group, teacher, room, lessonType, day);
    }
}
