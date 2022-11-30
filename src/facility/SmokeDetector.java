package facility;

public class SmokeDetector implements ISensor {
    public void triggered() {
        System.out.println("Smoke detected");
        System.out.println("fire brigade on a way");
    }
}
