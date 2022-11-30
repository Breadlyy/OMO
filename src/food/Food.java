package food;

import java.util.Random;

public class Food {
    Random random;
    Food()
    {
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
