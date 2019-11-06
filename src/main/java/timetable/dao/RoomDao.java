package timetable.dao;

import timetable.model.Room;
import timetable.model.RoomType;

import java.sql.*;

public class RoomDao {

    private Connection connection = ConnectionToDB.getConnection();

    public void addRoom(Room room) {
        try {
            String INSERT_ROOM = "INSERT INTO rooms(room_number, room_type) VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(INSERT_ROOM);
            statement.setInt(1, room.getNumber());
            statement.setString(2, room.getRoomType().name());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteRoom() {
        PreparedStatement statement;
        try {
            String sql = "delete from rooms where id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 2);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTableRoom() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.execute("DROP TABLE rooms CASCADE ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Room findRoomById(Long roomId) {
        Room room = new Room();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from rooms WHERE room_id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, Math.toIntExact(roomId));
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                room.setId(roomId);
                room.setNumber(rs.getInt("room_number"));
                room.setRoomType(RoomType.valueOf(rs.getString("room_type")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return room;
    }
}
