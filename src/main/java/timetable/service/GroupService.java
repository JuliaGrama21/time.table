package timetable.service;

import timetable.dao.GroupDao;
import timetable.model.Group;

import java.util.List;

public class GroupService {

    GroupDao groupDao = new GroupDao();

    public boolean addGroup(Group group) {
        return groupDao.addGroup(group);
    }

    public boolean deleteGroup(Long id) {
        return groupDao.deleteGroup(id);
    }

    public boolean updateGroup(Group group) {
        return groupDao.updateGroup(group);
    }

    public Long getGroupIdByNumber(int number) {
        return groupDao.getGroupIdByNumber(number);
    }

    public Group findGroupById(Long id) {
        return groupDao.findGroupById(id);
    }

    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }
}
