package main.java.tasks;

import main.java.humans.Adult;
import main.java.humans.Child;

/**
 * task to feed child
 */
public class FeedChildTask extends Task
{
    Child c;

    public FeedChildTask(Adult human, int complexity, int priority, Child c) {
        super(human, complexity, priority);
        this.c = c;
    }

    public void run()
    {
        human.feedChild(c);
    }
}
