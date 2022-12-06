package home.stuff;

import food.Food;

import java.util.Set;

public class Fridge extends Stuff{
    private int capacity;
    private Set<Food> food;
    public void eat(Food meal)
    {
        this.food.remove(meal);
    }
    public void put(Food meal)
    {
        this.food.add(meal);
    }
}
