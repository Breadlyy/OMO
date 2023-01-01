package home.stuff;

import food.Food;

public class Oven extends ElectricStuff{
    private int capacity;
    private Thread thread;
    public void heatFood(Food food) throws InterruptedException {
        thread.sleep(food.getCooked() * 100);
        energyConsumption+= food.getCooked()/100;
    }
}
