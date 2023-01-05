package humans;

import home.Home;
import tasks.FeedChildTask;
import tasks.Task;

public class Child extends Human {
    int i;
    public Child(String name, String surname, long passNo) {
        super(name, surname, passNo);
    }

    public void wantPlay()
    {
        System.out.println("Want to play");
    }
    public void wantFood()
    {
        home.getMother().enqueueTask(new FeedChildTask(home.getMother(),2,4, this));
        System.out.println("Want to eat");
    }
    public void wantSleep()
    {
        System.out.println("Want to play");
    }
    public void desire()
    {
        hungerRate--;
        i = (int)(Math.random() * 6);
        if(hungerRate<20)
        {
            wantFood();
            return;
        }
        if(i == 0)
        {
            wantPlay();
        }
        if(i == 1)
        {
            wantFood();
        }
        if(i == 2)
        {
            wantSleep();
        }
    }


    /**
     * There is always food for our baby
     * Noone has hunger rate, so just does nothing
     */
    public void eat()
    {
        hungerRate+=20;
    }

    public void run()
    {

    }
}
