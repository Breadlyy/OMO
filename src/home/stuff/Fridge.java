package home.stuff;

import food.Food;

import java.util.Set;

public class Fridge extends ElectricStuff{
    private static long capacity = 5000;
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
