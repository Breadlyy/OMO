package main.java.home.sensor;

import main.java.home.stuff.Stuff;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements ISensor {
    protected List<Stuff> stuff = new ArrayList<>();
    private long id;
    protected String text = "";


    public Sensor() {
        this.stuff = new ArrayList<>();
    }

    public void notifySensor() {
        System.out.println(text);
        for (Stuff s : stuff) {
            s.notifyStuff();
        }
    }

    public void add(Stuff s) {
        stuff.add(s);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
