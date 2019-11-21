package timetable.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import timetable.dao.GroupDao;
import timetable.service.GroupService;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GroupServiceTest {

    @Mock
    GroupDao groupDao;

    @InjectMocks
    GroupService groupService = new GroupService();

    @Test
    public void addGroupTest() {
        Group group = new Group();
        group.setId(10L);
        group.setNumber(244);
        group.setName("Computer Science");
        when(groupDao.addGroup(new Group(group.getId(), group.getNumber(), group.getName()))).thenReturn(true);
        boolean isAdded = groupService.addGroup(group);
        assertEquals(true, isAdded);
    }

    @Test
    public void deleteGroupTest() {
        Group group = new Group();
        group.setId(10L);
        group.setNumber(244);
        group.setName("Computer Science");
        when(groupDao.deleteGroup(group.getId())).thenReturn(true);
        boolean isDeleted = groupService.deleteGroup(group.getId());
        assertEquals(true, isDeleted);
    }

    @Test
    public void updateGroupTest() {
        Group group1 = new Group();
        group1.setId(10L);
        group1.setNumber(243);
        group1.setName("Computers Science");
        when(groupDao.updateGroup(group1)).thenReturn(false);
        boolean isUpdated = groupService.updateGroup(group1);
        assertEquals(false, isUpdated);
    }

    @Test
    public void getGroupIdByNumberTest() {
        Group group1 = new Group();
        group1.setId(10L);
        group1.setNumber(243);
        Long id1 = group1.getId();
        when(groupDao.getGroupIdByNumber(group1.getNumber())).thenReturn(id1);
        Long id = groupService.getGroupIdByNumber(group1.getNumber());
        assertEquals(id1, id);
    }

    @Test
    public void findGroupByIdTest() {
        Group group = new Group();
        group.setId(12L);
        group.setNumber(143);
        group.setName("Computer Science");
        GroupService groupService = new GroupService();
        Group group1 = groupService.findGroupById(group.getId());
        Group groupExpected = group;
        assertEquals(groupExpected, group1);
    }

    @Test
    public void getAllGroupsTest() {
        Group group1 = new Group();
        Group group2 = new Group();
        Group group3 = new Group();
        Group group4 = new Group();
        List<Group> groupList = new ArrayList<>();
        group1.setId(12L);
        group2.setId(18L);
        group3.setId(2L);
        group4.setId(1L);
        group1.setNumber(143);
        group2.setNumber(145);
        group3.setNumber(106);
        group4.setNumber(142);
        group1.setName("Computer Science");
        group2.setName("Computers Science");
        group3.setName("Computer Engineering");
        group4.setName("Engineering");
        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);
        groupList.add(group4);
        when(groupDao.getAllGroups()).thenReturn(groupList);
        List<Group> groups = groupService.getAllGroups();
        assertEquals(groupList, groups);
    }

    @Test
    public void checkGroupTest() {
        Group group1 = new Group();
        group1.setId(11L);
        group1.setNumber(243);
        group1.setName("Computer Science");
        when(groupDao.checkGroup(group1)).thenReturn(false);
        boolean isFree = groupService.checkGroup(group1);
        assertEquals(false, isFree);
    }


}