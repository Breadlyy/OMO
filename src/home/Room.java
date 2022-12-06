package home;

import home.stuff.Stuff;

import java.util.List;

public class Room {
    private final int height;
    private final int width;
    private final int length;
    private final Floor floor;
    private List<Stuff> stuff;


    public Room(int height, int width, int length, Floor floor) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.floor = floor;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public Floor getFloor() {
        return floor;
    }

    public List<Stuff> getStuff() {
        return stuff;
    }

    public void setStuff(List<Stuff> stuff) {
        this.stuff = stuff;
    }

    public void addStuff(Stuff stuff)
    {
        this.stuff.add(stuff);
    }

    public void removeSturr(Stuff stuff)
    {
        this.stuff.remove(stuff);
    }
}
