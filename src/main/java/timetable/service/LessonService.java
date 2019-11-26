package timetable.service;

import timetable.dao.HibernateLessonDao;
import timetable.dao.LessonDao;
import timetable.model.Lesson;

import java.util.List;

public class LessonService {

    private LessonDao lessonDaoo = new LessonDao();
    private HibernateLessonDao lessonDao = new HibernateLessonDao();

    public boolean addLesson(Lesson lesson) {
        return lessonDao.addLesson(lesson);
    }

    public List<Lesson> getAllLessons() {
        return lessonDao.getAllLessons();
    }

    public List<Lesson> getLessonsByTeacher(Long id) {
        return lessonDaoo.getLessonsByTeacher(id);
    }

    public List<Lesson> getLessonsByRoom(Long id) {
        return lessonDaoo.getLessonsByRoom(id);
    }

    public List<Lesson> getLessonsByGroup(Long id) {
        return lessonDaoo.getLessonsByGroup(id);
    }

    public boolean deleteLesson(Long id) {
        return lessonDao.deleteLesson(id);
    }

    public boolean updateLesson(Lesson lesson) {
        return lessonDao.updateLesson(lesson);
    }

    public Lesson findLessonById(Long lessonId) {
        return lessonDao.findLessonById(lessonId);
    }


}
