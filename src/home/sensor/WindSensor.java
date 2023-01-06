package home.sensor;

import home.stuff.Fridge;
import home.stuff.Shutter;
import home.stuff.Window;

import java.util.ArrayList;
import java.util.List;

public class WindSensor extends Sensor {
    List<Window> windows = new ArrayList<>();
    public void add(Window window)
    {
        windows.add(window);
    }

}
