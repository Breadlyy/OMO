package main.java.tasks;

import main.java.humans.Adult;
import main.java.humans.Child;

/**
 * Task to play with children
 */
public class PlayTask extends Task {
    private Child c;

    public PlayTask(Adult human, int complexity, int priority, Child c) {
        super(human, complexity, priority);
        this.c = c;
    }

    public void run() {
        human.playWith(c);
    }

}
