package main.java.tasks;

import main.java.home.stuff.Tap;
import main.java.humans.Adult;

public class CloseTapTask extends Task{
    Tap tap;
    public CloseTapTask(Adult human, int complexity, int priority, Tap tap) {
        super(human, complexity, priority);
        this.tap = tap;
    }
    public void run()
    {
        human.turnWaterOff(tap);
    }
}
