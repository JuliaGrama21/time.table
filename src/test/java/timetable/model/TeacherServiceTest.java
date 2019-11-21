package timetable.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import timetable.dao.TeacherDao;
import timetable.service.TeacherService;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TeacherServiceTest {

    @Mock
    TeacherDao teacherDao;

    @InjectMocks
    TeacherService teacherService = new TeacherService();

    @Test
    public void addTeacherTest() {
        Teacher teacher = new Teacher();
        teacher.setId(5L);
        teacher.setFirstName("David");
        teacher.setLastName("Back");
        teacher.setPosition("teacher");
        when(teacherService.addTeacher(teacher)).thenReturn(true);
        boolean isAdded = teacherService.addTeacher(teacher);
        assertEquals(true, isAdded);
    }

    @Test
    public void deleteTeacherTest() {
        Teacher teacher = new Teacher();
        teacher.setId(5L);
        when(teacherDao.deleteTeacher(teacher.getId())).thenReturn(true);
        boolean isDeleted = teacherService.deleteTeacher(teacher.getId());
        assertEquals(true, isDeleted);
    }

    @Test
    public void updateTeacherTest() {
        Teacher teacher1 = new Teacher();
        teacher1.setId(5L);
        teacher1.setFirstName("Victor");
        teacher1.setLastName("Brawn");
        teacher1.setPosition("teacher");
        when(teacherDao.updateTeacher(teacher1)).thenReturn(true);
        boolean isUpdated = teacherService.updateTeacher(teacher1);
        assertEquals(true, isUpdated);
    }

    @Test
    public void getTeacherIdByNameTest() {
        Teacher teacher1 = new Teacher();
        teacher1.setId(5L);
        teacher1.setFirstName("Victor");
        teacher1.setLastName("Brawn");
        Long id1 = teacher1.getId();
        when(teacherDao.getTeacherIdByName(teacher1.getFirstName(), teacher1.getLastName())).thenReturn(id1);
        Long id = teacherService.getTeacherIdByName(teacher1.getFirstName(), teacher1.getLastName());
        assertEquals(id1, id);
    }

    @Test
    public void findTeacherByIdTest() {
        Teacher teacher1 = new Teacher();
        teacher1.setId(5L);
        teacher1.setFirstName("Victor");
        teacher1.setLastName("Brawn");
        teacher1.setPosition("teacher");
        when(teacherDao.findTeacherById(teacher1.getId())).thenReturn(teacher1);
        Teacher teacher = teacherService.findTeacherById(teacher1.getId());
        assertEquals(teacher1, teacher);
    }

    @Test
    public void checkTeacherTest() {
        Teacher teacher1 = new Teacher();
        teacher1.setId(5L);
        teacher1.setFirstName("Victor");
        teacher1.setLastName("Brawn");
        teacher1.setPosition("teacher");
        when(teacherDao.checkTeacher(teacher1)).thenReturn(false);
        boolean isFree = teacherDao.checkTeacher(teacher1);
        assertEquals(false, isFree);
    }


}