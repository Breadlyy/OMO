package facility;

public class Fuse implements ISensor {
    public void triggered() {
        System.out.println("Fuse is melted");
    }
}
