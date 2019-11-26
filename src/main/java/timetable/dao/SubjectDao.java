package timetable.dao;

import timetable.model.Subject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDao implements ISubjectDao {
    private Connection connection = ConnectionToDB.getConnection();

    public boolean addSubject(Subject subject) {
        try {
            if (checkSubject(subject)) {
                String INSERT_SUBJECT = "INSERT INTO subjects(name) VALUES (?)";
                PreparedStatement statement = connection.prepareStatement(INSERT_SUBJECT);
                statement.setString(1, subject.getName());
                statement.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteSubject(Long id) {
        PreparedStatement statement;
        try {
            String sql = "delete from subjects where subject_id = ?";
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

    public boolean updateSubject(Subject subject) {
        PreparedStatement preparedStatement;
        String sql = "UPDATE subjects SET name = ? WHERE subject_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, subject.getName());
            preparedStatement.setLong(2, subject.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void dropTableSubject() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute("DROP TABLE subjects CASCADE ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Long getSubjectIdByName(String name) {
        Subject subject = new Subject();
        PreparedStatement statement;
        try {
            String sql = "SELECT subject_id from subjects WHERE name = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                subject.setId(rs.getLong("subject_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return subject.getId();
    }

    public Subject findSubjectById(Long subjectId) {
        Subject subject = new Subject();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from subjects WHERE subject_id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, subjectId);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                subject.setId(subjectId);
                subject.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return subject;
    }

    public List<Subject> getAllSubjects() {
        List<Subject> subjectList = new ArrayList<>();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from subjects";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setId(rs.getLong("subject_id"));
                subject.setName(rs.getString("name"));
                subjectList.add(subject);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return subjectList;
    }

    public boolean checkSubject(Subject subject) {
        PreparedStatement statement;
        try {
            String sql = "SELECT COUNT(*) from subjects WHERE name = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, subject.getName());
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
