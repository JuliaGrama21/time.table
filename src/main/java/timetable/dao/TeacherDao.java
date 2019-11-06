package timetable.dao;

import timetable.model.Teacher;

import java.sql.*;

public class TeacherDao {

    private Connection connection = ConnectionToDB.getConnection();

    public void addTeacher(Teacher teacher) {
        try {
            String INSERT_TEACHER = "INSERT INTO teachers(first_name, last_name, position) VALUES (?,?,? )";
            PreparedStatement statement = connection.prepareStatement(INSERT_TEACHER);
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getPosition());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
        }
    }

    public void deleteTeacher() {
        PreparedStatement statement;
        try {
            String sql = "delete from teachers where id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 2);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTableTeacher() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute("DROP TABLE teachers CASCADE ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Teacher findTeacherById(Long teacherId) {
        Teacher teacher = new Teacher();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from teachers WHERE teacher_id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Math.toIntExact(teacherId));
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                teacher.setId(teacherId);
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setLastName(rs.getString("last_name"));
                teacher.setPosition(rs.getString("position"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }
}
