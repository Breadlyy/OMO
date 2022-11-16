package humans;

import constructions.Window;
import facility.Fridge;
import facility.GasHeater;
import facility.Tap;
import transport.Transport;

public interface Adult {
    void eat(Fridge fridge);
    void feed_pet();
    void open_window(Window window);
    void ride(Transport transport);
    void turn_heating_on(GasHeater heater);
    void turn_water_on(Tap tap);
}
