package tasks;

import home.stuff.GasHeater;
import humans.Adult;

public class OpenHeaterTask extends Task{
    GasHeater gasHeater;
    public OpenHeaterTask(Adult human, int complexity, int priority, GasHeater gasHeater) {
        super(human, complexity, priority);
        this.gasHeater = gasHeater;
    }
    public void run(GasHeater gasHeater)
    {
        human.turnHeatingOn(gasHeater);
    }
}
