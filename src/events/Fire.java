package events;

public class Fire extends Event{
    public Fire()
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
        System.out.println("Fire spreading");
    }
}
