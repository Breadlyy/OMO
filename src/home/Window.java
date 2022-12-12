package home;

public class Window {
    private int height;
    private int width;
    private boolean opened;

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
}
