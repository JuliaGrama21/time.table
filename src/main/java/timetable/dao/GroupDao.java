package timetable.dao;

import org.apache.log4j.Logger;
import timetable.model.Group;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupDao implements IGroupDao {

    private static final Logger log = Logger.getLogger(GroupDao.class);

    private Connection connection = ConnectionToDB.getConnection();

    public boolean addGroup(Group group) {
        try {
            if (checkGroup(group)) {
                String INSERT_GROUP = "INSERT INTO groups(group_number, group_name) VALUES (?,?)";
                PreparedStatement statement = connection.prepareStatement(INSERT_GROUP);
                statement.setInt(1, group.getNumber());
                statement.setString(2, group.getName());
                statement.executeUpdate();
                log.info("method addGroup");
                return true;
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        return false;
    }

    public boolean deleteGroup(Long id) {
        PreparedStatement statement;
        try {
            String sql = "delete from groups where group_id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateGroup(Group group) {
        PreparedStatement preparedStatement;
        String sql = "UPDATE groups SET group_number = ?, group_name = ? WHERE group_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, group.getNumber());
            preparedStatement.setString(2, group.getName());
            preparedStatement.setLong(3, group.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void dropTableGroup() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute("DROP TABLE groups CASCADE ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Long getGroupIdByNumber(int number) {
        Group group = new Group();
        PreparedStatement statement;
        try {
            String sql = "SELECT group_id from groups WHERE group_number = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, number);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                group.setId(rs.getLong("group_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return group.getId();
    }

    public Group findGroupById(Long id) {
        Group group = new Group();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from groups WHERE group_id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                group.setId(id);
                group.setNumber(rs.getInt("group_number"));
                group.setName(rs.getString("group_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return group;
    }

    public List<Group> getAllGroups() {
        List<Group> groupList = new ArrayList<>();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from groups";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setId(rs.getLong("group_id"));
                group.setNumber(rs.getInt("group_number"));
                group.setName(rs.getString("group_name"));
                groupList.add(group);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return groupList;
    }

    public boolean checkGroup(Group group) {
        PreparedStatement statement;
        try {
            String sql = "SELECT COUNT(*) from groups WHERE group_number = ? AND group_name = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, group.getNumber());
            statement.setString(2, group.getName());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
