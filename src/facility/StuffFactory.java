package facility;

public class StuffFactory {
    public Oven createOven()
    {
        return new Oven();
    }
    public GasHeater createGasHeater()
    {
        return new GasHeater();
    }
    public Tap createTap()
    {
        return new Tap();
    }
    public Fridge createFridge()
    {
        return  new Fridge();
    }
    public Microwave createMicrowave()
    {
        return new Microwave();
    }
}
