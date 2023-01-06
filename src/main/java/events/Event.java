package main.java.events;

import main.java.home.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;

public abstract class Event{
     String text = "";
     protected List<Sensor> sensors = new ArrayList<>();

     public Event() {
          sensors = new ArrayList<>();
     }

     public void occur()
     {
          System.out.println(text);
          for(Sensor s: sensors) s.notifySensor();
     }

     public void attachSensor(Sensor sensor)
     {
          sensors.add(sensor);
     }

}