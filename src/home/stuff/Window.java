package home.stuff;

public class Window extends Stuff{
    private int height;
    private int width;
    private boolean opened;
    private  Shutter shutter;

    public boolean isOpened() {
        return opened;
    }
    public void open()
    {
        this.opened = true;
        System.out.println("Shutter opened");
    }
    public void close()
    {
        this.opened = false;
        System.out.println("Shutter closed");
    }

    public Shutter getShutter() {
        return shutter;
    }

    public void setShutter(Shutter shutter) {
        this.shutter = shutter;
    }
}
