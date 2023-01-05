package events;

import home.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

}