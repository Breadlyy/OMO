package tasks;

import home.stuff.GasHeater;
import humans.Adult;

public class CloseHeaterTask extends Task{
    GasHeater gasHeater;
    public CloseHeaterTask(Adult human, int complexity, int priority, GasHeater gasHeater) {
        super(human, complexity, priority);
        this.gasHeater = gasHeater;
    }
    public void run()
    {
        human.turnHeatingOff(gasHeater);
    }
}
