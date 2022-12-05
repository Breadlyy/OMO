package events;

import home.sensor.Sensor;

import java.util.List;
import java.util.Random;

public abstract class Event implements IEvent {

     protected List<Sensor> sensors;

     public Event() {
     }

     public void occur()
     {
          for(Sensor s: sensors) s.notifySensor();
     }

}