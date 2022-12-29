package home.sensor;

import home.stuff.Fridge;
import home.stuff.Shutter;
import observer.Observed;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WindSensor extends Sensor {
    List<Shutter> shutters = new ArrayList<>();
    public void add(Shutter shutter)
    {
        shutters.add(shutter);
    }

}
