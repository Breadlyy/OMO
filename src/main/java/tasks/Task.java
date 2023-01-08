package main.java.tasks;

import main.java.humans.Adult;

/**
 * task that will be done in future
 */
public class Task {
    private final int complexity; // time that it needs to be done
    public final int priority;
    protected Adult human;

    public Task(Adult human, int complexity, int priority) {
        this.human = human;
        this.complexity = complexity;
        this.priority = priority;
    }

    public int getComplexity() {
        return complexity;
    }

    /**
     * perform a task
     */
    public void run() {
        return;
    }

    public int getPriority() {
        return priority;
    }
}
