package main.java.tasks;

import main.java.home.stuff.Window;
import main.java.humans.Adult;

/**
 * task to close the window
 */
public class CloseWindowTask extends Task {
    private Window window;

    public CloseWindowTask(Adult human, int complexity, int priority, Window window) {
        super(human, complexity, priority);
        this.window = window;
    }

    public void run() {
        human.closeWindow(window);
    }
}
