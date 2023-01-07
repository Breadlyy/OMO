package main.java.tasks;

import main.java.humans.Adult;

/**
 * Task to eat
 */
public class EatTask extends Task{

    public EatTask(Adult human, int complexity, int priority) {
        super(human, complexity, priority);

    }
    public void run()
    {
        human.eat();
    }
}
