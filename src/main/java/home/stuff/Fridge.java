package main.java.home.stuff;

import main.java.food.Food;

import java.util.ArrayList;
import java.util.List;

public class Fridge extends ElectricStuff {
    private static long capacity = 5000;
    private List<Food> food = new ArrayList<>();

    public void eat(Food f) {
        this.food.remove(f);
    }

    public void put(Food meal) {
        this.food.add(meal);
    }

    public List<Food> getFood() {
        return food;
    }

    public boolean empty() {
        return food.isEmpty();
    }

    public Fridge() {
        state = new StuffState();
        state.turnOn();
    }
}
