package tasks;

import home.stuff.Fridge;
import humans.Adult;
import humans.Human;

public class EatTask extends Task{

    public EatTask(Adult human, int complexity, int priority) {
        super(human, complexity, priority);

    }
    public void run()
    {
        human.eat();
    }
}
