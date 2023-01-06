package sport;

public abstract class SportStuff
{
    int busyCount = 0;
    private int id;


    /**
     * True if stuff is used
     * @return
     */
    public boolean isBusy(){return busyCount!=0;}
    public void run()
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
