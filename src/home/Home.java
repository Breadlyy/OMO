package home;

import animals.Pet;
import events.*;
import home.sensor.*;
import home.stuff.Stuff;
import home.stuff.StuffIterator;
import humans.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    protected ShortCircuit shortCircuit;
    protected WaterLeak waterLeak;
    protected WindBlow windBlow;
    public StuffIterator iterator;
    private int rand;

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


    private Home() {
        this.fire = new Fire();
        this.gasLeak = new GasLeak();
        this.shortCircuit = new ShortCircuit();
        this.waterLeak = new WaterLeak();
        this.windBlow = new WindBlow();
        iterator = new StuffIterator(this);
    }

    public static Home getExample() {
        if (home == null) {
            home = new Home();
        }
        return home;
    }
    public double generateReport(Stuff stuff)
    {
        return stuff.generateReport();
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

    public List<Floor> getFloors() {
        return floors;
    }

    public static Home getHome() {
        return home;
    }

    public Men getFather() {
        return father;
    }

    public Woman getMother() {
        return mother;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<Pet> getPets() {
        return pets;
    }
    public Adult getRandomPerson()
    {
        rand = (int)(Math.random() * 2);
        if(rand == 0) return getFather();
        return getMother();
    }
}
