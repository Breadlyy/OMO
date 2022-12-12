package home;

import home.stuff.Stuff;


import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Room {
    private final int height;
    private final int width;
    private final int length;
    private final Floor floor;
    private List<Stuff> stuff;
    private Map sensors;

    public Room(int height, int width, int length, Floor floor, Map sensors) {
        this.height = height;
        this.width = width;
        this.length = length;
        this.floor = floor;
        this.sensors = new HashMap();
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

    public void removeStuff(Stuff stuff)
    {
        this.stuff.remove(stuff);
    }


    public Iterator getIterator() {
        return new StuffIterator();
    }

    private class StuffIterator implements Iterator
    {
        int index;
        @Override
        public boolean hasNext() {
            if(index < stuff.size())
            {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            Stuff stuff1 = stuff.get(index);
            index++;
            return stuff1;
        }
    }
    public interface Iterator {
        public boolean hasNext();
        public Object next();
    }
    public interface Collection {
        Iterator getIterator();
    }

}

