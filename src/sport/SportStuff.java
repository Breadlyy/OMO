package sport;

public abstract class SportStuff
{
    int busyCount = 0;

    /**
     * True if stuff is used
     * @return
     */
    public boolean isBusy(){return busyCount!=0;}
    public void run()
    {
    }
}
