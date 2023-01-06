package main.java.home.stuff;

import main.java.home.stuff.state.StuffState;

public class Tap extends Stuff {
    private int water_consumed;
    public Tap(int water_consumption) {
        super();
        this.water_consumption = water_consumption;
        state = new StuffState();
        state.powerOn();
    }

    public void run()
    {
        if(state.active()){ water_consumed+=water_consumption;
        runEnabled();}
    }

    private int water_consumption;
    @Override
    public String generateReport()
    {
        return  "Tap "+getId()+ " consumed "+ water_consumed;
    }
}
