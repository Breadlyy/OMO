package main.java.tasks;

import main.java.home.stuff.Oven;
import main.java.humans.Adult;

public class CloseOvenTask extends Task
{
    Oven oven;
    public CloseOvenTask(Adult human, int complexity, int priority, Oven o) {
        super(human, complexity, priority);
        this.oven=o;
    }

    public void run()
    {
        oven.turnOff();
    }
}
