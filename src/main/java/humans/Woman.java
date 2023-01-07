package main.java.humans;

import main.java.tasks.Task;

public class Woman extends Adult {

    public Woman(String name, String surname, long passNo) {
        super(name, surname, passNo);
    }

    public void enqueueTask(Task t) {

        if(taskQueue.size()>1 && home.getFather().taskQueue.isEmpty())
        {
            home.getFather().enqueueTask(t);
            System.out.println("Mother asked dad to take her task");
        }
        else taskQueue.add(t);
    }
}
