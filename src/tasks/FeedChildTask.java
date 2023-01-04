package tasks;

import humans.Adult;
import humans.Child;
import humans.Human;

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
