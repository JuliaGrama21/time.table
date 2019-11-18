package timetable.dao;

import timetable.model.Day;
import timetable.model.Lesson;
import timetable.model.LessonType;
import timetable.model.TimeSlot;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private Connection connection = ConnectionToDB.getConnection();

    public void addLesson(Lesson lesson) {
        try {
            if (isGroupAvailable(lesson) && isRoomAvailable(lesson) && isTeacherAvailable(lesson)) {
                String INSERT_LESSON = "INSERT INTO lessons(time_slot, id_group, id_teacher, id_room, lesson_type, day) VALUES (?,?,?,?,?,?)";
                PreparedStatement statement = connection.prepareStatement(INSERT_LESSON);
                statement.setString(1, String.valueOf(lesson.getTimeSlot()));
                statement.setLong(2, lesson.getGroup().getId());
                statement.setLong(3, lesson.getTeacher().getId());
                statement.setLong(4, lesson.getRoom().getId());
                statement.setString(5, String.valueOf(lesson.getLessonType()));
                statement.setString(6, String.valueOf(lesson.getDay()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Lesson> getLessonsByTeacher(Long id) {
        List<Lesson> lessonsForTeacher = new ArrayList<>();
        GroupDao groupDao = new GroupDao();
        RoomDao roomDao = new RoomDao();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from lessons WHERE id_teacher = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String lessonId = rs.getString("lesson_id");
                TimeSlot timeSlot = TimeSlot.valueOf(rs.getString("time_slot"));
                Long groupId = rs.getLong("id_group");
                Long roomId = rs.getLong("id_room");
                LessonType lessonType = LessonType.valueOf(rs.getString("lesson_type"));
                Day day = Day.valueOf(rs.getString("day"));
                Lesson lesson = new Lesson();
                lesson.setId(Long.valueOf(lessonId));
                lesson.setTimeSlot(timeSlot);
                lesson.setGroup(groupDao.findGroupById(groupId));
                lesson.setRoom(roomDao.findRoomById(roomId));
                lesson.setLessonType(lessonType);
                lesson.setDay(day);
                lessonsForTeacher.add(lesson);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(lessonsForTeacher);
        return lessonsForTeacher;
    }

    public List<Lesson> getLessonsByRoom(Long id) {
        List<Lesson> lessonsForRoom = new ArrayList<>();
        GroupDao groupDao = new GroupDao();
        TeacherDao teacherDao = new TeacherDao();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from lessons WHERE id_room = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String lessonId = rs.getString("lesson_id");
                TimeSlot timeSlot = TimeSlot.valueOf(rs.getString("time_slot"));
                Long groupId = rs.getLong("id_group");
                Long teacherId = rs.getLong("id_teacher");
                LessonType lessonType = LessonType.valueOf(rs.getString("lesson_type"));
                Day day = Day.valueOf(rs.getString("day"));
                Lesson lesson = new Lesson();
                lesson.setId(Long.valueOf(lessonId));
                lesson.setTimeSlot(timeSlot);
                lesson.setGroup(groupDao.findGroupById(groupId));
                lesson.setTeacher(teacherDao.findTeacherById(teacherId));
                lesson.setLessonType(lessonType);
                lesson.setDay(day);
                lessonsForRoom.add(lesson);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lessonsForRoom;
    }

    public List<Lesson> getLessonsByGroup(Long id) {
        List<Lesson> lessonsForGroup = new ArrayList<>();
        RoomDao roomDao = new RoomDao();
        TeacherDao teacherDao = new TeacherDao();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from lessons WHERE id_group = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String lessonId = rs.getString("lesson_id");
                TimeSlot timeSlot = TimeSlot.valueOf(rs.getString("time_slot"));
                Long roomId = rs.getLong("id_room");
                Long teacherId = rs.getLong("id_teacher");
                LessonType lessonType = LessonType.valueOf(rs.getString("lesson_type"));
                Day day = Day.valueOf(rs.getString("day"));
                Lesson lesson = new Lesson();
                lesson.setId(Long.valueOf(lessonId));
                lesson.setTimeSlot(timeSlot);
                lesson.setRoom(roomDao.findRoomById(roomId));
                lesson.setTeacher(teacherDao.findTeacherById(teacherId));
                lesson.setLessonType(lessonType);
                lesson.setDay(day);
                lessonsForGroup.add(lesson);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lessonsForGroup;
    }

    public void deleteLesson(Long id) {
        PreparedStatement statement = null;
        Connection connection = null;
        try {
            String sql = "delete from lessons where lesson_id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean updateLesson(Lesson lesson) {
        PreparedStatement preparedStatement;
        String sql = "UPDATE rooms SET time_slot = ?, id_group, id_teacher, id_room = ?, lesson_type = ?, day = ? WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(lesson.getTimeSlot()));
            preparedStatement.setLong(2, lesson.getGroup().getId());
            preparedStatement.setLong(2, lesson.getTeacher().getId());
            preparedStatement.setLong(2, lesson.getRoom().getId());
            preparedStatement.setString(1, String.valueOf(lesson.getLessonType()));
            preparedStatement.setString(1, String.valueOf(lesson.getDay()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void dropTableLesson() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute("DROP TABLE lessons");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isRoomAvailable(Lesson lesson) {
        PreparedStatement statement;
        try {
            String sqlTeacher = "SELECT COUNT(*) from lessons WHERE id_room = ? AND time_slot = ? AND day = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sqlTeacher);
            statement.setInt(1, Math.toIntExact(lesson.getRoom().getId()));
            statement.setString(2, lesson.getTimeSlot().name());
            statement.setString(3, lesson.getDay().name());
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

    public boolean isGroupAvailable(Lesson lesson) {
        PreparedStatement statement;
        try {
            String sqlTeacher = "SELECT COUNT(*) from lessons WHERE id_group = ? AND time_slot = ? AND day = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sqlTeacher);
            statement.setInt(1, Math.toIntExact(lesson.getGroup().getId()));
            statement.setString(2, lesson.getTimeSlot().name());
            statement.setString(3, lesson.getDay().name());
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

    public boolean isTeacherAvailable(Lesson lesson) {
        PreparedStatement statement;
        try {
            String sqlTeacher = "SELECT COUNT(*) from lessons WHERE id_teacher = ? AND time_slot = ? AND day = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sqlTeacher);
            statement.setInt(1, Math.toIntExact(lesson.getTeacher().getId()));
            statement.setString(2, lesson.getTimeSlot().name());
            statement.setString(3, lesson.getDay().name());
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

    public Lesson findLessonById(Long lessonId) {
        Lesson lesson = new Lesson();
        GroupDao groupDao = new GroupDao();
        RoomDao roomDao = new RoomDao();
        TeacherDao teacherDao = new TeacherDao();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from lessons WHERE lesson_id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, lessonId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                lesson.setId(lessonId);
                lesson.setTimeSlot(TimeSlot.valueOf(rs.getString("time_slot")));
                lesson.setGroup(groupDao.findGroupById(rs.getLong("id_group")));
                lesson.setRoom(roomDao.findRoomById(rs.getLong("id_room")));
                lesson.setTeacher(teacherDao.findTeacherById(rs.getLong("id_teacher")));
                lesson.setLessonType(LessonType.valueOf(rs.getString("lesson_type")));
                lesson.setDay(Day.valueOf(rs.getString("day")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lesson;
    }
}