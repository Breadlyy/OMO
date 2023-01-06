package main.java.home;

import java.util.ArrayList;
import java.util.List;

public class Floor
{
    private final long number;
    private final Home home;
    private List<Room> rooms = new ArrayList<>();

    public Floor(Home home, long number)
    {
        this.home = home; this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public Home getHome() {
        return home;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRoom(Room room)
    {
        rooms.add(room);
    }

    public void removeRoom(Room room)
    {
        rooms.remove(room);
    }

}
