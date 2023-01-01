package events;

import home.sensor.Sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Event implements IEvent {

     protected List<Sensor> sensors = new ArrayList<>();

     public Event() {
          sensors = new ArrayList<>();
     }

     public void occur()
     {
          for(Sensor s: sensors) s.notifySensor();
     }

}