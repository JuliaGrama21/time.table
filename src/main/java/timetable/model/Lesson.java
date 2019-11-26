package timetable.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @Column(name = "lesson_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "time_slot", length = 16)
    private TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(name = "id_subject")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "id_group")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "id_teacher")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;

    @Enumerated(EnumType.STRING)
    @Column(name = "lesson_type", length = 10)
    private LessonType lessonType;

    @Enumerated(EnumType.STRING)
    @Column(name = "day", length = 10)
    private Day day;

    public Lesson() {
    }

    public Lesson(Long id, TimeSlot timeSlot, Subject subject, Group group, Teacher teacher, Room room, LessonType lessonType, Day day) {
        this.id = id;
        this.timeSlot = timeSlot;
        this.subject = subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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
                ", subject=" + subject +
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
                Objects.equals(subject, lesson.subject) &&
                Objects.equals(group, lesson.group) &&
                Objects.equals(teacher, lesson.teacher) &&
                Objects.equals(room, lesson.room) &&
                lessonType == lesson.lessonType &&
                day == lesson.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, timeSlot, subject, group, teacher, room, lessonType, day);
    }
}
