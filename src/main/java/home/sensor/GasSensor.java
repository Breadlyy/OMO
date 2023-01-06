package main.java.home.sensor;

import main.java.home.stuff.GasHeater;

public class GasSensor extends Sensor {
    public GasSensor()
    {
        super();
    }

    public void add(GasHeater gasHeater)
    {
        stuff.add(gasHeater);
    }
}
