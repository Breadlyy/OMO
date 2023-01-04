package tasks;

import home.stuff.Fridge;
import humans.Adult;
import humans.Human;

public class GoForFoodTask extends EatTask
{
    private Fridge f;

    public GoForFoodTask(Adult human, int complexity, int priority, Fridge f) {
        super(human, complexity, priority, f);
    }
    public void run()
    {
        human.goForFood(f);
    }
}
