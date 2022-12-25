package home.stuff;

import home.stuff.state.StuffState;

public abstract class Stuff  {
    protected float energyConsumption;//water or energy
    protected StuffState state = new StuffState();
    private long id;
    public float generateReport()
    {
        return energyConsumption;
    }

    public float getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(float energyConsumption) {
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
