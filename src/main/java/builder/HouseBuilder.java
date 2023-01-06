package builder;

import animals.Pet;
import home.Floor;
import home.Home;
import home.Room;
import humans.Child;
import humans.Human;
import humans.Men;
import humans.Woman;

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
