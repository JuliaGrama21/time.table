package timetable.dao;

import timetable.model.Subject;

import java.util.List;

public interface ISubjectDao {

    boolean addSubject(Subject subject);

    boolean updateSubject(Subject subject);

    boolean deleteSubject(Long id);

    Subject findSubjectById(Long id);

    List<Subject> getAllSubjects();
}
