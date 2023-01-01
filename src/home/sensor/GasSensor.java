package home.sensor;

import home.stuff.Fridge;
import home.stuff.GasHeater;

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
