package timetable.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TimeTable {

    private Set<Lesson> lessons;

    public TimeTable() {
    }

    public TimeTable(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson) {
        if (lessons == null) {
            lessons = new HashSet<>();
        }

        if (checkRoom(lesson)) {
            System.out.println("Кімната " + lesson.getRoom().getNumber() + " зайнята");
        } else if (checkGroup(lesson)) {
            System.out.println("Група " + lesson.getGroup().getNumber() + " зайнята");
        } else if (checkTeacher(lesson)) {
            System.out.println("Викладач " + lesson.getTeacher().getName() + " зайнятий");
        } else {
            lessons.add(lesson);
        }
    }

    public Set<Lesson> getTimeTableForTeacher(Teacher teacher) {
        if (lessons == null) {
            lessons = new HashSet<>();
        }
        Set<Lesson> lessonsOfTeacher = lessons.stream()
                .filter(Lesson -> Lesson.getTeacher().equals(teacher))
                .collect(Collectors.toSet());
        System.out.println("List for teacher " + lessonsOfTeacher);
        return lessonsOfTeacher;
    }

    public Set<Lesson> getTimeTableForGroup(Group group) {
        Set<Lesson> lessonsOfGroup = lessons.stream()
                .filter(Lesson -> Lesson.getGroup().equals(group))
                .collect(Collectors.toSet());
        System.out.println("List for group " + lessonsOfGroup);
        return lessonsOfGroup;
    }

    public Set<Lesson> getTimeTableForRoom(Room room) {
        Set<Lesson> lessonsOfRoom = lessons.stream()
                .filter(Lesson -> Lesson.getRoom().equals(room))
                .collect(Collectors.toSet());
        System.out.println("List for room " + lessonsOfRoom);
        return lessonsOfRoom;
    }

    public boolean checkRoom(Lesson lesson) {
        for (Lesson lessonn : lessons) {
            if (lessonn.getRoom().getNumber() == lesson.getRoom().getNumber() &&
                    lessonn.getTimeSlot() == lesson.getTimeSlot() &&
                    lessonn.getDay() == lesson.getDay()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkGroup(Lesson lesson) {
        for (Lesson lessonn : lessons) {
            if (lessonn.getGroup().getNumber() == lesson.getGroup().getNumber() &&
                    lessonn.getDay() == lesson.getDay() &&
                    lessonn.getTimeSlot() == lesson.getTimeSlot() &&
                    lessonn.getTeacher() == lesson.getTeacher()) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTeacher(Lesson lesson) {
        for (Lesson lessonn : lessons) {
            if (lessonn.getTeacher().getName().equals(lesson.getTeacher().getName()) &&
                    lessonn.getDay() == lesson.getDay() &&
                    lessonn.getTimeSlot() == lesson.getTimeSlot()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "TimeTable{" +
                "lessons=" + lessons +
                '}';
    }
}

