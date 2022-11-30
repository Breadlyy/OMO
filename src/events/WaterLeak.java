package events;

import java.util.Random;

public class WaterLeak implements IEvent {
    public WaterLeak()
    {
        occur();
    }
    private boolean happening = false;
    Random random;
    public void setHappening(boolean happening)
    {
        this.happening = happening;
    }
    public boolean getHappening()
    {
        return this.happening;
    }
    @Override
    public void occur() {
            setHappening(true);
             System.out.println("Water leak");
    }
}
