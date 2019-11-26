package timetable.dao;

import timetable.model.Group;

import java.util.List;

public interface IGroupDao {

    boolean addGroup(Group group);

    boolean deleteGroup(Long id);

    boolean updateGroup(Group group);

    Group findGroupById(Long id);

    List<Group> getAllGroups();
}
