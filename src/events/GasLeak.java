package events;

import home.sensor.GasSensor;
import home.sensor.SmokeDetector;

public class GasLeak extends Event{
    public void attachSensor(GasSensor sensor) {
        sensors.add(sensor);
    }

    public GasLeak() {
        text = "Gas leaked!";
    }
}
