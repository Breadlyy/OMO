package tasks;

import home.stuff.Tap;
import humans.Adult;

public class OpenTapTask extends Task {
    Tap tap;
    public OpenTapTask(Adult human, int complexity, int priority, Tap tap) {
        super(human, complexity, priority);
        this.tap = tap;
        run(tap);
    }
    public void run(Tap tap)
    {
        human.turnWaterOn(tap);
    }
}
