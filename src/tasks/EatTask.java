package tasks;

import home.stuff.Fridge;
import humans.Adult;
import humans.Human;

public class EatTask extends Task{
private Fridge f;
    public EatTask(Adult human, int complexity, int priority, Fridge f) {
        super(human, complexity, priority);
        this.f=f;
    }
    public void run()
    {
        human.eat(f);
    }
}
