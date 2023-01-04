package home.stuff;

import home.Room;
import home.stuff.state.StuffState;

import java.util.Random;

public abstract class Stuff  {
    int i;
    int durability = 100;



    private Room room;
    protected double energyConsumption;//water or energy
    protected StuffState state = new StuffState();
    private static double consumedEnergy;
    private long id;
    public double generateReport()
    {
        return consumedEnergy;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public Stuff()
    {
        state = new StuffState();
        state.powerOn();
    }
    public void turnOn()
    {
        state.turnOn();
    }
    public void turnOff()
    {
        state.turnOff();
    }
    public void powerOn()
    {
        state.powerOn();
    }
    public void powerOff()
    {
        state.powerOff();
    }
    public void breakThis()
    {
        state.breakThing();

    }
    public void repairThis()
    {
        state.repair();
    }
    public void doWork()
    {

    }

    public void notifyStuff()
    {
        System.out.println("Stuff is off");
        powerOff();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void run()
    {
        consumedEnergy+=energyConsumption;
        i = (int)(Math.random() * 5);
        if(i > 4)
        {
            if(checkDurability())
            {
                durability-=20;
                return;
            }
         breakThis();
        }
    }
    private boolean checkDurability()
    {
        return this.durability > 0;
    }

    public String toString()
    {
        String s = this.getClass().getSimpleName() + "\nWith id " + id;
        return s;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    //    public void turnOff()
//    {
//        if(this.state != StuffState.disabled)
//        {
//            this.state = StuffState.idle;
//        }
//    }
//    public void turnOn()
//    {
//        if(this.state != StuffState.disabled)
//        {
//            this.state = StuffState.active;
//        }
//    }
//    public void collapsed()
//    {
//        this.state = StuffState.disabled;
//    }

}
