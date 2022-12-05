package home.sensor;

import home.stuff.Fridge;
import home.stuff.Shutter;
import observer.Observed;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WindSensor implements ISensor {
    List<Shutter> shutters;


    public void add(Shutter shutter)
    {
        shutters.add(shutter);
    }


    @Override
    public void notifySensor() {
        for(Shutter s: shutters)
        {
            s.close();
        }
    }
}
