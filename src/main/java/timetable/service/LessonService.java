package timetable.service;

import timetable.dao.LessonDao;
import timetable.model.Lesson;

import java.util.List;

public class LessonService {

    private LessonDao lessonDao = new LessonDao();

    public boolean addLesson(Lesson lesson) {
        return lessonDao.addLesson(lesson);
    }

    public List<Lesson> getAllLessons() {
        return lessonDao.getAllLessons();
    }

    public List<Lesson> getLessonsByTeacher(Long id) {
        return lessonDao.getLessonsByTeacher(id);
    }

    public List<Lesson> getLessonsByRoom(Long id) {
        return lessonDao.getLessonsByRoom(id);
    }

    public List<Lesson> getLessonsByGroup(Long id) {
        return lessonDao.getLessonsByGroup(id);
    }

    public void deleteLesson(Long id) {
        lessonDao.deleteLesson(id);
    }

    public boolean updateLesson(Lesson lesson) {
        return lessonDao.updateLesson(lesson);
    }

    public Lesson findLessonById(Long lessonId) {
        return lessonDao.findLessonById(lessonId);
    }


}
