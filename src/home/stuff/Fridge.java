package home.stuff;

import food.Food;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Fridge extends ElectricStuff{
    private static long capacity = 5000;
    private List<Food> food = new ArrayList<>();
    public void eat(Food f)
    {
        this.food.remove(f);
    }
    public void put(Food meal)
    {
        this.food.add(meal);
    }

    public List<Food> getFood() {
        return food;
    }
    public boolean empty()
    {
        return food.isEmpty();
    }
}
