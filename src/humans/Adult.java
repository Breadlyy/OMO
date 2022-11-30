package humans;

import constructions.Window;
import facility.Fridge;
import facility.GasHeater;
import facility.Tap;
import transport.Transport;

public interface Adult {
    public void eat(Fridge fridge);
    public void feed_pet();
    public void open_window(Window window);
    public void ride(Transport transport);
    public void turn_heating_on(GasHeater heater);
    public void turn_heating_off(GasHeater heater);
    public void turn_water_on(Tap tap);
    public void turn_water_off(Tap tap);
}
