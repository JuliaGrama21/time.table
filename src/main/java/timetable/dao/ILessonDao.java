package timetable.dao;

import timetable.model.Lesson;

import java.util.List;

public interface ILessonDao {

    boolean addLesson(Lesson lesson);

    boolean deleteLesson(Long id);

    boolean updateLesson(Lesson lesson);

    Lesson findLessonById(Long id);

    List<Lesson> getAllLessons();
}
