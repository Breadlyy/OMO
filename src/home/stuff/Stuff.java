package home.stuff;

import home.stuff.state.StuffState;

public abstract class Stuff  {
    protected float energyConsumption;
    protected StuffState state;
    public float generateReport()
    {
        return energyConsumption;
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
        powerOff();
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
