package timetable.model;

import java.util.Objects;

public class Room {


    private Long id;
    private int number;
    private RoomType roomType;

    public Room() {
    }

    public Room(Long id, int number, RoomType roomType) {
        this.id = id;
        this.number = number;
        this.roomType = roomType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", number=" + number +
                ", roomType=" + roomType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return number == room.number &&
                roomType == room.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, roomType);
    }
}
