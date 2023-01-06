package main.java.tasks;

import main.java.humans.Adult;

public class Task
{
    private final int complexity;
    public final int priority;
    protected Adult human;

    public Task(Adult human,int complexity, int priority) {
        this.human = human;
        this.complexity = complexity;
        this.priority = priority;
    }

    public int getComplexity() {
        return complexity;
    }

    public String getTask() {
        return "";
    }
    public void run()
    {
        return;
    }
    public int getPriority() {
        return priority;
    }
}
