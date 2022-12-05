package home.sensor;

import home.stuff.Fridge;
import home.stuff.Microwave;

public class Fuse extends Sensor
{

    public void add(Microwave microwave)
    {
        stuff.add(microwave);
    }

    public void add(Fridge fridge)
    {
        stuff.add(fridge);
    }
}
