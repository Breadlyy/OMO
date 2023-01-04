package tasks;

import animals.Pet;
import home.stuff.Fridge;
import home.stuff.Stuff;
import humans.Adult;
import humans.Human;

public class FeedPetTask extends Task
{
    Pet p;

    public FeedPetTask(Adult human, int complexity, int priority, Pet p) {
        super(human, complexity, priority);
        this.p = p;
    }

    @Override
    public void run()
    {
        Fridge f = human.findNonEmptyFridge();
    }
}
