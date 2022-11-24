package facility;

import events.Event;
import events.IEvent;
import events.WaterLeak;

public class WaterSensor implements ISensor {

    public void triggered() {
        System.out.println("Water leakage is prevented");
    }
}
