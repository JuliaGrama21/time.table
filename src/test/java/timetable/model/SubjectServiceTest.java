package timetable.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import timetable.dao.SubjectDao;
import timetable.service.SubjectService;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceTest {

    @Mock
    SubjectDao subjectDao;

    @InjectMocks
    SubjectService subjectService = new SubjectService();

    @Test
    public void addSubjectTest() {
        Subject subject = new Subject();
        subject.setId(5L);
        subject.setName("c#");
        when(subjectDao.addSubject(subject)).thenReturn(true);
        boolean isAdded = subjectService.addSubject(subject);
        assertEquals(true, isAdded);
    }

    @Test
    public void deleteSubjectTest() {
        Subject subject = new Subject();
        subject.setId(5L);
        when(subjectDao.deleteSubject(subject.getId())).thenReturn(true);
        boolean isDeleted = subjectService.deleteSubject(subject.getId());
        assertEquals(true, isDeleted);
    }

    @Test
    public void updateSubjectTest() {
        Subject subject1 = new Subject();
        subject1.setId(6L);
        subject1.setName("db");
        when(subjectDao.updateSubject(subject1)).thenReturn(true);
        boolean isUpdated = subjectService.updateSubject(subject1);
        assertEquals(true, isUpdated);
    }

    @Test
    public void getSubjectIdByNameTest() {
        Subject subject1 = new Subject();
        subject1.setId(6L);
        subject1.setName("db");
        Long id1 = subject1.getId();
        when(subjectDao.getSubjectIdByName(subject1.getName())).thenReturn(id1);
        Long id = subjectService.getSubjectIdByName(subject1.getName());
        assertEquals(id1, id);
    }

    @Test
    public void findSubjectByIdTest() {
        Subject subject1 = new Subject();
        subject1.setId(6L);
        subject1.setName("db");
        when(subjectDao.findSubjectById(subject1.getId())).thenReturn(subject1);
        Subject subject = subjectService.findSubjectById(subject1.getId());
        assertEquals(subject1, subject);
    }

    @Test
    public void checkSubjectTest() {
        Subject subject1 = new Subject();
        subject1.setId(6L);
        subject1.setName("db");
        when(subjectDao.checkSubject(subject1)).thenReturn(false);
        boolean isFree = subjectDao.checkSubject(subject1);
        assertEquals(false, isFree);
    }


}