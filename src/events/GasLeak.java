package events;

public class GasLeak extends Event{
    public GasLeak()
    {
        occur();
    }
    private boolean happening = false;
    public void setHappening(boolean happening)
    {
        this.happening = happening;
    }
    @Override
    public void occur() {
        setHappening(true);
        System.out.println("Gas leak");
    }
}
