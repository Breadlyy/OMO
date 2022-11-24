package events;

public class ShortCircuit extends Event {
    private boolean happening = false;
    public ShortCircuit()
    {
        occur();
    }

    public void setHappening(boolean happening)
    {
        this.happening = happening;
    }
    @Override
    public void occur() {
        setHappening(true);
        System.out.println("Short circuit");
    }
}
