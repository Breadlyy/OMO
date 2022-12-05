package events;

import home.sensor.SmokeDetector;

public class Fire extends Event{
    public void attachSensor(SmokeDetector sensor) {
        sensors.add(sensor);
    }
}
