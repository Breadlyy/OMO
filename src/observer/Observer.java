package observer;

import constructions.Shutter;

import java.util.List;

public interface Observer {
    public void handleEvent(List<Shutter> shutters);
}
