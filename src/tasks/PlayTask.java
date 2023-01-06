package tasks;

import humans.Adult;
import humans.Child;

public class PlayTask extends Task
{
    Child c;
    public PlayTask(Adult human, int complexity, int priority, Child c) {
        super(human, complexity, priority);
        this.c = c;
    }

    public void run()
    {
        human.playWith(c);
    }

}
