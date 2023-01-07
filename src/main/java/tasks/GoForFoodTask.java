package main.java.tasks;

import main.java.home.stuff.Fridge;
import main.java.humans.Adult;

/**
 * Task to go for food
 */
public class GoForFoodTask extends EatTask
{
    private Fridge f;

    public GoForFoodTask(Adult human, int complexity, int priority, Fridge f) {
        super(human, complexity, priority);
        this.f=f;
    }
    public void run()
    {
        human.goForFood(f);
    }
}
