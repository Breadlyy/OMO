package main.java.tasks;

import main.java.home.stuff.Window;
import main.java.humans.Adult;

public class CloseWindowTask extends Task{
    Window window;
    public CloseWindowTask(Adult human, int complexity, int priority, Window window) {
        super(human, complexity, priority);
        this.window = window;
    }
    public void run()
    {
        human.closeWindow(window);
    }
}
