package timetable.dao;

import timetable.model.Teacher;

import java.util.List;

public interface ITeacherDao {

    boolean addTeacher(Teacher teacher);

    boolean updateTeacher(Teacher teacher);

    boolean deleteTeacher(Long id);

    Teacher findTeacherById(Long id);

    List<Teacher> getAllTeachers();
}
