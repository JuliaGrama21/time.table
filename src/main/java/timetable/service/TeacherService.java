package timetable.service;

import timetable.dao.HibernateTeacherDao;
import timetable.dao.TeacherDao;
import timetable.model.Teacher;

import java.util.List;

public class TeacherService {

    private TeacherDao teacherDaoo = new TeacherDao();
    private HibernateTeacherDao teacherDao = new HibernateTeacherDao();

    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    public boolean deleteTeacher(Long id) {
        return teacherDao.deleteTeacher(id);
    }

    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    public Long getTeacherIdByName(String firstName, String lastName) {
        return teacherDaoo.getTeacherIdByName(firstName, lastName);
    }

    public Teacher findTeacherById(Long teacherId) {
        return teacherDao.findTeacherById(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }
}
