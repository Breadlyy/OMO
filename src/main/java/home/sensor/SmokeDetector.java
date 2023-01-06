package main.java.home.sensor;

import main.java.home.stuff.Stuff;

public class SmokeDetector extends Sensor {
 //turns off everything when fire
    public void add(Stuff stuff)
    {
        this.stuff.add(stuff);
    }
}
