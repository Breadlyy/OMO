package events;

import home.sensor.SmokeDetector;
import home.sensor.WaterSensor;

public class WindBlow extends Event {
    public void attachSensor(WaterSensor sensor) {
        sensors.add(sensor);
    }
}
