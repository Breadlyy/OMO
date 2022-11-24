package facility;

public class WindSensor implements ISensor{
    public void triggered() {
        System.out.println("Closing shutters");
    }
}
