package observer;

import home.stuff.Shutter;

import java.util.List;

public interface Observer {
    public void handleEvent(List<Shutter> shutters);
}
