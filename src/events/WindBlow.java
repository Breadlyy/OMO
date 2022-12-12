package events;

import home.sensor.SmokeDetector;
import home.sensor.WaterSensor;
import home.sensor.WindSensor;

public class WindBlow extends Event {
    public void attachSensor(WindSensor sensor) {
        sensors.add(sensor);
    }
}
