package facility;

public class GasSensor implements ISensor{
    public void triggered() {
        System.out.println("Service of gas is called");
    }
}
