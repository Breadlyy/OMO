package home;

import animals.Pet;
import events.*;
import home.sensor.*;
import humans.Human;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Home {
    private static Home home;
    private List<Human> human;
    private List<Pet> pets;
    private List<Floor> floors;
    private List<Sensor> sensors = new ArrayList<>();
    public String values;
    protected Fire fire;
    protected GasLeak gasLeak;

    public Fire getFire() {
        return fire;
    }

    public GasLeak getGasLeak() {
        return gasLeak;
    }

    public ShortCircuit getShortCircuit() {
        return shortCircuit;
    }

    public WaterLeak getWaterLeak() {
        return waterLeak;
    }

    public WindBlow getWindBlow() {
        return windBlow;
    }

    protected ShortCircuit shortCircuit;
    protected WaterLeak waterLeak;
    protected WindBlow windBlow;
    private Home(String values) {
        this.values = values;
        this.fire = new Fire();
        this.gasLeak = new GasLeak();
        this.shortCircuit = new ShortCircuit();
        this.waterLeak = new WaterLeak();
        this.windBlow = new WindBlow();

    }
    public static Home getExample(String values) {

        if (home == null) {

            home = new Home(values);

        }
        return home;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

}
