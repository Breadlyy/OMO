import facility.Oven;
import facility.Sensor;
import facility.Stuff;
import facility.StuffFactory;

public class Main {
    public static void main(String[] args) {
        Sensor sensor = new Sensor();
        StuffFactory stuffFactory = new StuffFactory();
        stuffFactory.createGasHeater();
        stuffFactory.createFridge();

    }
}
