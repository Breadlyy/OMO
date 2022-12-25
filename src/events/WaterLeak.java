package events;

import home.sensor.SmokeDetector;
import home.sensor.WaterSensor;

import java.util.Random;

public class WaterLeak extends Event {

    public WaterLeak() {
        super();
    }

    public void attachSensor(WaterSensor sensor) {
        sensors.add(sensor);
    }
}
