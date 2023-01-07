package main.java.home.stuff;

public class Tap extends Stuff {
    private int water_consumed; //tap does not consume energy, but consumes water
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
