package timetable.dao;

import timetable.model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDao {

    private Connection connection = ConnectionToDB.getConnection();

    public boolean addTeacher(Teacher teacher) {
        try {
            if (checkTeacher(teacher)) {
                String INSERT_TEACHER = "INSERT INTO teachers(first_name, last_name, position) VALUES (?,?,?)";
                PreparedStatement statement = connection.prepareStatement(INSERT_TEACHER);
                statement.setString(1, teacher.getFirstName());
                statement.setString(2, teacher.getLastName());
                statement.setString(3, teacher.getPosition());
                statement.executeUpdate();
                return true;
            }
            //statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteTeacher(Long id) {
        PreparedStatement statement;
        try {
            String sql = "delete from teachers where teacher_id = ?";
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

    public boolean updateTeacher(Teacher teacher) {
        PreparedStatement preparedStatement;
        String sql = "UPDATE teachers SET first_name = ?, last_name = ?, position = ? WHERE teacher_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, teacher.getFirstName());
            preparedStatement.setString(2, teacher.getLastName());
            preparedStatement.setString(3, teacher.getPosition());
            preparedStatement.setLong(4, teacher.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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

    public Long getTeacherIdByTeacher(Teacher teacher) {
        PreparedStatement statement;
        try {
            String sql = "SELECT teacher_id from teachers WHERE first_name = ? AND last_name = ? AND position = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getPosition());
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                teacher.setId(rs.getLong("teacher_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teacher.getId();
    }

    public Long getTeacherIdByName(String firstName, String lastName) {
        Teacher teacher = new Teacher();
        PreparedStatement statement;
        try {
            String sql = "SELECT teacher_id from teachers WHERE first_name = ? AND last_name = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                teacher.setId(rs.getLong("teacher_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teacher.getId();
    }

    public Teacher findTeacherById(Long teacherId) {
        Teacher teacher = new Teacher();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from teachers WHERE teacher_id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, teacherId);
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

    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = new ArrayList<>();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from teachers";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("teacher_id"));
                teacher.setFirstName(rs.getString("first_name"));
                teacher.setLastName(rs.getString("last_name"));
                teacher.setPosition(rs.getString("position"));
                teacherList.add(teacher);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return teacherList;
    }

    public boolean checkTeacher(Teacher teacher) {
        PreparedStatement statement;
        try {
            String sqlTeacher = "SELECT COUNT(*) from teachers WHERE first_name = ? AND last_name = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sqlTeacher);
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
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
