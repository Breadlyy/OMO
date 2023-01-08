package main.java.animals;

import main.java.home.Home;
import main.java.tasks.FeedPetTask;

/**
 * General  class for Pets
 */
public abstract class Pet {
    private String name;
    int i;
    private Home home;

    protected void say() {
        System.out.println("base");
    }

    /**
     * Add task to father to feed it.
     * If father is busy, waits
     */
    public void wantFood() {
        System.out.println(name + "wants to eat");
        home.getFather().enqueueTask(new FeedPetTask(home.getFather(), 1, 2, this));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Randomly wants to eat
     */
    public void run() {
        i = (int) (Math.random() * 8);
        if (i == 0) {
            wantFood();
        } else if (i == 2) say();

    }
}
