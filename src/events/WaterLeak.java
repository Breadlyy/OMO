package events;

import home.sensor.SmokeDetector;
import home.sensor.WaterSensor;

import java.util.Random;

public class WaterLeak extends Event {

    public WaterLeak() {
        text = "Water leaked!";
    }

}
