package home;

import animals.Pet;
import events.*;
import home.sensor.*;
import humans.Child;
import humans.Human;
import humans.Men;
import humans.Woman;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Home {
    private static Home home;
    private Men father;
    private Woman mother;
    private List<Child> children = new ArrayList<>();
    private List<Pet> pets = new ArrayList<>();
    private List<Floor> floors = new ArrayList<>();
    private List<Sensor> sensors = new ArrayList<>();
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
    private Home() {
        this.fire = new Fire();
        this.gasLeak = new GasLeak();
        this.shortCircuit = new ShortCircuit();
        this.waterLeak = new WaterLeak();
        this.windBlow = new WindBlow();

    }

    public static Home getExample() {
        if (home == null) {
            home = new Home();
        }
        return home;
    }

    public void addFloor(Floor floor)
    {
        floors.add(floor);
    }

    public void addChild(Child person)
    {
        this.children.add(person);
    }

    public void addPet(Pet pet)
    {
        this.pets.add(pet);
    }

    public void clear()
    {
        father=null ;
        mother=null;
        pets.clear();
        children.clear();
        floors.clear();
        sensors.clear();
    }

    public void setFather(Men father) {
        this.father = father;
    }

    public void setMother(Woman mother) {
        this.mother = mother;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

}
