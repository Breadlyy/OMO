package events;

public class WindBlow extends Event {
    public WindBlow()
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
        System.out.println("Wind blow");
    }
}
