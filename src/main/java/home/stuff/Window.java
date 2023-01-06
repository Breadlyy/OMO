package main.java.home.stuff;

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
        consumedEnergy+=7;
        System.out.println("Window "+getId()+ " opened");
    }
    public void close()
    {
        consumedEnergy+=7;
        this.opened = false;
        System.out.println("Window "+getId()+ " closed");
    }

    public Shutter getShutter() {
        return shutter;
    }

    public void setShutter(Shutter shutter) {
        this.shutter = shutter;
    }
}
