package main.java.home.sensor;

import main.java.home.stuff.Window;


import java.util.ArrayList;
import java.util.List;

public class WindSensor extends Sensor {
    protected List<Window> windows = new ArrayList<>();

    public void add(Window window) {
        windows.add(window);
    }

}
