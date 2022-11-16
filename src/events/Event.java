package events;

public abstract class Event implements IEvent {
     public void occur()
     {
          System.out.println("Happening");
     }

}