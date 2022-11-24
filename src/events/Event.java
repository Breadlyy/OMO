package events;

import java.util.Random;

public abstract class Event implements IEvent {

     public void occur()
     {
          System.out.println("Happening");
     }

}