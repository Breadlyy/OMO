package home.stuff;

import home.stuff.Stuff;

public class Tap extends Stuff {
    private int water_consumed;
    public Tap(int water_consumption) {
        super();
        this.water_consumption = water_consumption;
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
