package sport;

public abstract class SportStuff
{
    int busyCount = 0;
    private long id;


    /**
     * True if stuff is used
     * @return
     */
    public boolean isBusy(){return busyCount!=0;}
    public void run()
    {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
