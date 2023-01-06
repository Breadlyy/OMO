package tasks;

import home.stuff.Oven;
import humans.Adult;

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
