package facility;

import constructions.Shutter;
import constructions.Window;
import observer.Observed;
import observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class WindSensor implements ISensor, Observed, Observer {
    private boolean triggered;
    public List<Shutter> shutters = new ArrayList<>();
    public void addShutter(Shutter shutter)
    {
        shutters.add(shutter);
    }
    public void triggered() {
        System.out.println("Closing shutters");
        handleEvent(shutters);
        this.triggered = true;
    }
    public void windowInteract(Shutter shutter)
    {
        if(triggered) shutter.open();
        else shutter.close();
    }

    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void removeObserver(Observer observer) {

    }

    @Override
    public void notifyObservers() {

    }

    @Override
    public void handleEvent(List<Shutter> shutters) {
        for (Shutter shutter : shutters)
        {
            windowInteract(shutter);
        }
    }
}
