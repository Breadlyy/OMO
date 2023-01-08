package main.java.events;

import main.java.home.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;

/**
 * general class for  all events
 * contains text that is written when event occured and list of sensors to notify
 */
public abstract class Event {
    protected String text = "";
    protected List<Sensor> sensors = new ArrayList<>();

    public Event() {
        sensors = new ArrayList<>();
    }

    public void occur() {
        System.out.println(text);
        for (Sensor s : sensors) s.notifySensor();
    }

    public void attachSensor(Sensor sensor) {
        sensors.add(sensor);
    }

}