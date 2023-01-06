package home.stuff;

public class Shutter extends ElectricStuff {
    private boolean opened;

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
    public void open()
    {
        this.opened = true;
        System.out.println("Shutter " + getId() + " opened");
    }
    public void close()
    {
        this.opened = false;
        System.out.println("Shutter " + getId() + " closed");
    }
}
