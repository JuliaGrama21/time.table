package timetable.service;

import timetable.dao.HibernateSubjectDao;
import timetable.dao.SubjectDao;
import timetable.model.Subject;

import java.util.List;

public class SubjectService {

    SubjectDao subjectDaoo = new SubjectDao();
    private HibernateSubjectDao subjectDao = new HibernateSubjectDao();

    public boolean addSubject(Subject subject) {
        return subjectDao.addSubject(subject);
    }

    public boolean deleteSubject(Long id) {
        return subjectDao.deleteSubject(id);
    }

    public boolean updateSubject(Subject subject) {
        return subjectDao.updateSubject(subject);
    }

    public Long getSubjectIdByName(String name) {
        return subjectDaoo.getSubjectIdByName(name);
    }

    public Subject findSubjectById(Long subjectId) {
        return subjectDao.findSubjectById(subjectId);
    }

    public List<Subject> getAllSubjects() {
        return subjectDao.getAllSubjects();
    }
}
