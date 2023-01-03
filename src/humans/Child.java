package humans;

import home.Home;

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
        System.out.println("Want to eat");
    }
    public void wantSleep()
    {
        System.out.println("Want to play");
    }
    public void desire()
    {
        i = (int)(Math.random() * 6);
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

}
