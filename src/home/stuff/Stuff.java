package home.stuff;

import home.Room;
import home.stuff.state.StuffState;
import humans.Adult;
import tasks.FixStuffTask;
import tasks.Task;

import java.util.Random;

public abstract class Stuff {
    int i;
    int durability = 100;


    private Room room;
    protected double energyConsumption;//water or energy
    protected StuffState state = new StuffState();
    private static double consumedEnergy;
    private long id;
    private String name;

    public String generateReport() {
        return  getClass().getSimpleName()+" "+ id + " consumed " + consumedEnergy;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public Stuff() {
        state = new StuffState();
        state.powerOn();
    }

    public void turnOn() {
        state.turnOn();
    }

    public void turnOff() {
        state.turnOff();
    }

    public void powerOn() {
        state.powerOn();
    }

    public void powerOff() {
        state.powerOff();
    }

    public void breakThis() {
        state.breakThing();
        Adult dad = room.getFloor().getHome().getFather();
        dad.enqueueTask(new FixStuffTask(dad, 2, 1, this));
    }

    public void repairThis() {
        state.repair();
    }

    public void notifyStuff() {
        System.out.println("Stuff " + getName() + " is off");
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
        state.handle(this);
    }


    public void runEnabled() {

        consumedEnergy += energyConsumption;
        i = (int) (Math.random() * 5);
        if (i > 4) {
            if (checkDurability()) {
                durability -= 20;
                return;
            }
            breakThis();
        }
    }

    private boolean checkDurability() {
        return this.durability > 0;
    }

    public String toString() {
        String s = this.getClass().getSimpleName() + "\nWith id " + id;
        return s;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean active()
    {
        return state.active();
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
