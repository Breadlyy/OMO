package main.java.humans;

import main.java.tasks.FeedChildTask;
import main.java.tasks.PlayTask;

public class Child extends Human {
    int i;
    public Child(String name, String surname, long passNo) {
        super(name, surname, passNo);
    }

    public void wantPlay()
    {
        System.out.println("Children "+ name + " wants to play" );
    }
    public void wantFood()
    {
        home.getMother().enqueueTask(new FeedChildTask(home.getMother(),2,4, this));
        System.out.println("Children "+ name + " wants to eat" );
    }
    public void wantSleep()
    {
        System.out.println("Children "+ name + " wants sleep");
        home.getFather().hide();
    }
    public void run()
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
            home.getMother().enqueueTask(new PlayTask(home.getMother(), 2, 2, this));
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
     * There is always main.java.food for our baby
     * Noone has hunger rate, so just does nothing
     */
    public void eat()
    {
        hungerRate+=20;
    }

}
