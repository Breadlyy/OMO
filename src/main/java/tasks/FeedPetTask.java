package main.java.tasks;

import main.java.animals.Pet;
import main.java.humans.Adult;

/**
 * Task to feed pet
 */
public class FeedPetTask extends Task {
    private Pet p;

    public FeedPetTask(Adult human, int complexity, int priority, Pet p) {
        super(human, complexity, priority);
        this.p = p;
    }

    @Override
    public void run() {
        human.feedPet(p);
    }
}
