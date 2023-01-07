package main.java.tasks;

import main.java.home.stuff.GasHeater;
import main.java.humans.Adult;

/**
 * Task to close heater
 */
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
