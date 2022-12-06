package home;

import home.stuff.Stuff;

import java.util.List;

public class Floor
{
    private final int number;
    private final Home home;
    private List<Room> rooms;

    public Floor(Home home, int number)
    {
        this.home = home; this.number = number;
    }

    public int getNumber() {
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
