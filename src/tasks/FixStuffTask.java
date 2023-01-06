package tasks;

import home.stuff.Stuff;
import humans.Adult;

public class FixStuffTask extends Task
{
    Stuff s;
    public FixStuffTask(Adult human, int complexity, int priority, Stuff s) {
        super(human, complexity, priority);
        this.s = s;
    }

    public void run()
    {
        human.repair(s);
    }

}
