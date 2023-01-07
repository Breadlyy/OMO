package main.java.tasks;

import main.java.home.stuff.Stuff;
import main.java.humans.Adult;

/**
 * Task to fix stuff
 */
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
