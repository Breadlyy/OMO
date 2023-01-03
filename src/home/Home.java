package home;

import animals.Pet;
import events.*;
import home.sensor.*;
import home.stuff.Stuff;
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
    protected ShortCircuit shortCircuit;
    protected WaterLeak waterLeak;
    protected WindBlow windBlow;

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

    private class StuffIterator
    {
        int floornum=0, roomnum=0, stuffnum=0;

        public boolean hasNext() {
            if(floors.get(floornum).getRooms().get(roomnum).getStuff().size()>stuffnum+1) return true;
            for(int tfloornum=floornum; tfloornum < floors.size(); tfloornum++)
            {
                for(int troomnum=roomnum; troomnum < floors.get(tfloornum).getRooms().size(); troomnum++)
                {
                    if(floors.get(tfloornum).getRooms().get(troomnum).getStuff().size()>0) return true;
                }
            }
            return false;
        }

        public Stuff begin()
        {
            for(int tfloornum=0; tfloornum < floors.size(); tfloornum++)
                 {
                     for(int troomnum=0; troomnum < floors.get(tfloornum).getRooms().size(); troomnum++)
                     {
                         if(floors.get(tfloornum).getRooms().get(troomnum).getStuff().size()>0) return  floors.get(tfloornum).getRooms().get(troomnum).getStuff().get(0);
                     }
                 }
        }

        public Stuff next() {
            if(floors.get(floornum).getRooms().get(roomnum).getStuff().size()>stuffnum+1)
            {
                stuffnum++;
                return floors.get(floornum).getRooms().get(roomnum).getStuff().get(stuffnum);
            }
            for(int tfloornum=floornum; tfloornum < floors.size(); tfloornum++)
            {
                for(int troomnum=roomnum; troomnum < floors.get(tfloornum).getRooms().size(); troomnum++)
                {
                    for(int tstuffnum=stuffnum; tstuffnum < floors.get(tfloornum).getRooms().get(troomnum).getStuff().size(); tstuffnum++)
                    {
                        floornum=tfloornum;
                        roomnum=troomnum;
                        stuffnum=tstuffnum;
                        return floors.get(floornum).getRooms().get(roomnum).getStuff().get(stuffnum);
                    }
                }
            }
            return null;
        }
    }

}
