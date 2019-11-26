package timetable.service;

import timetable.dao.GroupDao;
import timetable.dao.HibernateGroupDao;
import timetable.model.Group;

import java.util.List;

public class GroupService {

    private GroupDao groupDaoo = new GroupDao();
    private HibernateGroupDao groupDao = new HibernateGroupDao();

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
        return groupDaoo.getGroupIdByNumber(number);
    }

    public Group findGroupById(Long id) {
        return groupDao.findGroupById(id);
    }

    public List<Group> getAllGroups() {
        return groupDao.getAllGroups();
    }

    public boolean checkGroup(Group group) {
        return groupDaoo.checkGroup(group);
    }

}
