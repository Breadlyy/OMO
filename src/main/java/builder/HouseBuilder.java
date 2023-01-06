package main.java.builder;

import main.java.animals.Pet;
import main.java.home.Floor;
import main.java.home.Home;
import main.java.home.Room;
import main.java.humans.Child;
import main.java.humans.Men;
import main.java.humans.Woman;

public class HouseBuilder
{
    Home home;

    public HouseBuilder()
    {
        home = Home.getExample();
    }
    public Home getHome()
    {
        return home;
    }

    public HouseBuilder addFloor(Floor floor)
    {
        home.addFloor(floor);
        return this;
    }
    public void addRoom(Room room, Floor floor)
    {
        floor.addRoom(room);
    }
    public HouseBuilder setMother(Woman w)
    {
        home.setMother(w);
        w.setHome(home);
        return this;
    }

    public HouseBuilder setFather(Men m)
    {
        home.setFather(m);
        m.setHome(home);
        return this;
    }

    public HouseBuilder addChild(Child person)
    {
        home.addChild(person);
        person.setHome(home);
        return this;
    }

    public HouseBuilder addPet(Pet pet)
    {
        home.addPet(pet);
        return this;
    }

    public Home build()
    {
        return home;
    }
}
