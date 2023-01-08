package main.java.home;

import main.java.home.stuff.Stuff;


import java.util.*;

public class Room {
    private final long height;
    private final long width;
    private final long length;
    private final Floor floor;
    private List<Stuff> stuff;
    private Map sensors;

    /**
     * Constructor with final parameters
     *
     * @param height
     * @param width
     * @param length
     * @param floor
     */
    public Room(long height, long width, long length, Floor floor) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.floor = floor;
        this.sensors = new HashMap();
        stuff = new ArrayList<>();
    }

    public long getHeight() {
        return height;
    }

    public long getWidth() {
        return width;
    }

    public long getLength() {
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

    /**
     * adds stuff to room. Setf stuff room to this
     *
     * @param stuff
     */
    public void addStuff(Stuff stuff) {
        this.stuff.add(stuff);
        stuff.setRoom(this);
    }

    /**
     * removes stuff from rhis room
     *
     * @param stuff
     */
    public void removeStuff(Stuff stuff) {
        this.stuff.remove(stuff);
    }


}

