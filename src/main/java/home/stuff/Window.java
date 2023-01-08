package main.java.home.stuff;

/**
 * window is no that standart stuff, but it also consumes energy when it opens or closes
 */
public class Window extends Stuff {
    private int height;
    private int width;
    private boolean opened;
    private Shutter shutter;

    public boolean isOpened() {
        return opened;
    }

    /**
     * opens window
     */
    public void open() {
        this.opened = true;
        consumedEnergy += 7;
        System.out.println("Window " + getId() + " opened");
    }

    /**
     * closes window
     */
    public void close() {
        consumedEnergy += 7;
        this.opened = false;
        System.out.println("Window " + getId() + " closed");
    }

    public Shutter getShutter() {
        return shutter;
    }

    public void setShutter(Shutter shutter) {
        this.shutter = shutter;
    }

    public String generateReport() {
        return getClass().getSimpleName() + " " + getId() + " consumed " + consumedEnergy + (opened ? " opened" : " closed");
    }
}
