package timetable.dao;

import timetable.model.Group;

import java.sql.*;

public class GroupDao {

    private Connection connection = ConnectionToDB.getConnection();

    public void addGroup(Group group) {
        try {
            String INSERT_GROUP = "INSERT INTO groups(group_number, group_name) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(INSERT_GROUP);
            statement.setInt(1, group.getNumber());
            statement.setString(2, group.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }

    public void deleteGroup(Group group) {
        PreparedStatement statement;
        try {
            String sql = "delete from groups where id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 3);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public Group findGroupById(Long groupId) {
        Group group = new Group();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from groups WHERE group_id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Math.toIntExact(groupId));
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                group.setId(groupId);
                group.setNumber(rs.getInt("group_number"));
                group.setName(rs.getString("group_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return group;
    }
}
