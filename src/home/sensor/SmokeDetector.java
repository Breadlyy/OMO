package home.sensor;

import home.sensor.ISensor;
import home.stuff.Fridge;
import home.stuff.Stuff;

public class SmokeDetector extends Sensor {
 //turns off everything when fire
    public void add(Stuff stuff)
    {
        this.stuff.add(stuff);
    }
}
