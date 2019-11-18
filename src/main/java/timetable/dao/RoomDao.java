package timetable.dao;

import timetable.model.Room;
import timetable.model.RoomType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            e.printStackTrace();
        }
    }

    public void deleteRoom(Long id) {
        PreparedStatement statement;
        try {
            String sql = "delete from rooms where room_id = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean updateRoom(Room room) {
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE rooms SET room_number = ?, room_type = ? WHERE room_id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, room.getNumber());
            preparedStatement.setString(2, String.valueOf(room.getRoomType()));
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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

    public Long getRoomIdByNumber(int number) {
        Room room = new Room();
        PreparedStatement statement;
        try {
            String sql = "SELECT room_id from rooms WHERE room_number = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, number);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                room.setId(rs.getLong("room_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return room.getId();
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

    public String getRoomTypeByNumber(int number) {
        Room room = new Room();
        PreparedStatement statement;
        try {
            String sql = "SELECT room_type from rooms WHERE room_number = ?";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, number);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                room.setRoomType(RoomType.valueOf(rs.getString("room_type")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return room.getRoomType().name();
    }

    public List<Room> getAllRooms() {
        List<Room> roomList = new ArrayList<>();
        PreparedStatement statement;
        try {
            String sql = "SELECT * from rooms";
            connection = ConnectionToDB.getConnection();
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getLong("room_id"));
                room.setNumber(rs.getInt("room_number"));
                room.setRoomType(RoomType.valueOf(rs.getString("room_type")));
                roomList.add(room);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return roomList;
    }
}
