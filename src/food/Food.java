package food;

import java.util.Random;

public class Food {
    Random random;
    public Food()
    {
        random = new Random();
        setCooked(100);
    }
    private int cooked;

    public int getCooked() {
        return cooked;
    }

    public void setCooked(int cooked) {
        this.cooked = random.nextInt(cooked);
    }
}
