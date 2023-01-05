package events;

import home.sensor.Fuse;
import home.sensor.SmokeDetector;

public class ShortCircuit extends Event {


    public ShortCircuit() {
        text = "Oh no, it's short circuit!";
    }

    public void attachSensor(Fuse sensor) {
        sensors.add(sensor);

    }


}
