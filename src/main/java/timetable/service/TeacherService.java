package timetable.service;

import timetable.dao.TeacherDao;
import timetable.model.Teacher;

import java.util.List;

public class TeacherService {

    private TeacherDao teacherDao = new TeacherDao();

    public boolean addTeacher(Teacher teacher) {
        return teacherDao.addTeacher(teacher);
    }

    public boolean deleteTeacher(Long id) {
        return teacherDao.deleteTeacher(id);
    }

    public boolean updateTeacher(Teacher teacher) {
        return teacherDao.updateTeacher(teacher);
    }

    public Long getTeacherIdByTeacher(Teacher teacher) {
        return teacherDao.getTeacherIdByTeacher(teacher);
    }

    public Long getTeacherIdByName(String firstName, String lastName) {
        return teacherDao.getTeacherIdByName(firstName, lastName);
    }

    public Teacher findTeacherById(Long teacherId) {
        return teacherDao.findTeacherById(teacherId);
    }

    public List<Teacher> getAllTeachers() {
        return teacherDao.getAllTeachers();
    }
}
