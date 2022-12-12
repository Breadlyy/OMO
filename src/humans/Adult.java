package humans;

import home.Window;
import home.sensor.Sensor;
import home.stuff.Fridge;
import home.stuff.GasHeater;
import home.stuff.Tap;
import transport.Transport;

import javax.swing.plaf.PanelUI;
import java.util.List;

public interface Adult {
    public void eat(Fridge fridge);
    public void feed_pet();
    public void open_window(Window window);
    public void close_window(Window window);
    public void ride(Transport transport);
    public void turn_heating_on(GasHeater heater);
    public void turn_heating_off(GasHeater heater);
    public void turn_water_on(Tap tap);
    public void turn_water_off(Tap tap);
    public void screw_up();
}
