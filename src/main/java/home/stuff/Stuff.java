package main.java.home.stuff;

import main.java.home.Room;
import main.java.humans.Adult;
import main.java.tasks.FixStuffTask;

public abstract class Stuff {
    int i;
    int durability = 100;


    private Room room;
    protected double energyConsumption;//water or energy
    protected StuffState state = new StuffState();
    protected double consumedEnergy;
    private long id;
    private String name;

    /**
     * Reports on it's state
     *
     * @return
     */
    public String generateReport() {
        return getClass().getSimpleName() + " " + id + " consumed " + consumedEnergy + " isactive " + state.active() + " broken " + state.broken();
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

    /**
     * Changes state to broken and asks daddy to fix it
     */
    private void breakThis() {
        state.breakThing();
        Adult dad = room.getFloor().getHome().getFather();
        dad.enqueueTask(new FixStuffTask(dad, 2, 1, this));
    }

    /**
     * Changes stuff state to idle
     * adds durability
     */
    public void repairThis() {
        durability = 100;
        state.repair();
    }

    /**
     * To be notified by sensor about event. Turns off when notified
     */
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


    public boolean isOff() {
        return state.getState() == StuffState.getOff();
    }

    public boolean idIdle() {
        return state.getState() == StuffState.getIdle();
    }

    /**
     * run based on stuff state
     */
    public void run() {
        state.handle(this);
    }


    /**
     * run when enabled (called from state class)
     */
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


    /**
     * Returns if stuff is broken
     *
     * @return
     */
    public boolean checkDurability() {
        return this.durability > 0;
    }

    public String toString() {
        String s = this.getClass().getSimpleName() + "\nWith id " + id;
        return s;
    }

    /**
     * Returns stuff location
     *
     * @return
     */
    public Room getRoom() {
        return room;
    }

    /**
     * sets stuff location
     *
     * @param room
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * rrturns if actual state is active
     *
     * @return
     */
    public boolean active() {
        return state.active();
    }

    /**
     * Consumes energu when IDLE state
     */
    public void runIDLE() {
        consumedEnergy += energyConsumption / 2;
    }

    public StuffState.State getState() {
        return state.getState();
    }
}
