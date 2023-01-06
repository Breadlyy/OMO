package events;

import home.sensor.GasSensor;
import home.sensor.SmokeDetector;

public class GasLeak extends Event {

    public GasLeak() {
        text = "Gas leaked!";
    }
}
