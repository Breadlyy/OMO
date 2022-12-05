package events;

import home.sensor.Fuse;
import home.sensor.SmokeDetector;

public class ShortCircuit extends Event {
    public void attachSensor(Fuse sensor) {
        sensors.add(sensor);
    }
}
