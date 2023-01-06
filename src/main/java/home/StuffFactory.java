package main.java.home;

import main.java.home.stuff.*;

public class StuffFactory {
    public Oven createOven()
    {
        return new Oven();
    }
    public GasHeater createGasHeater()
    {
        return new GasHeater();
    }
    public Tap createTap(int water)
    {
        return new Tap(water);
    }
    public Fridge createFridge()
    {
        return  new Fridge();
    }
    public Microwave createMicrowave()
    {
        return new Microwave();
    }
    public Window createWindow() {return new Window();}
    public Shutter createShutter(){return new Shutter();
    }
}
