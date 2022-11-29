package facility;

public abstract class Stuff  {
    protected float energyConsumption;
    protected StuffState state;
    public float generateReport()
    {
        return energyConsumption;
    }
    public void turnOff()
    {
        if(this.state != StuffState.disabled)
        {
            this.state = StuffState.idle;
        }
    }
    public void turnOn()
    {
        if(this.state != StuffState.disabled)
        {
            this.state = StuffState.active;
        }
    }
    public void collapsed()
    {
        this.state = StuffState.disabled;
    }

}
