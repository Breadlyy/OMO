package main.java.food;

import java.util.Random;

/**
 * Something  that human eats
 */
public class Food {

    public Food()
    {
        cooked = (int)Math.random()*30+20;
        setCooked(100);
    }
    private int cooked;

    public int getCooked() {
        return cooked;
    }

    public void setCooked(int cooked) {
        this.cooked = cooked*2;
    }
}
