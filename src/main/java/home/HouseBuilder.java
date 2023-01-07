package main.java.home;


import main.java.animals.Pet;
import main.java.humans.Child;
import main.java.humans.Men;
import main.java.humans.Woman;

public class HouseBuilder
{
    Home home;

    /**
     * constructor gets instance of singleton home
     */
    public HouseBuilder()
    {
        home = Home.getExample();
    }

    /**
     * Returns home at this stage of building
     * @return
     */
    public Home getHome()
    {
        return home;
    }

    /**
     * adds floor to building
     * @param floor
     * @return
     */
    public HouseBuilder addFloor(Floor floor)
    {
        home.addFloor(floor);
        return this;
    }

    /**
     * adds room to floor
     * @param room
     * @param floor
     */
    public void addRoom(Room room, Floor floor)
    {
        floor.addRoom(room);
    }

    /**
     * sets mother to the home
     * there is only one mother in house
     * @param w
     * @return
     */
    public HouseBuilder setMother(Woman w)
    {
        home.setMother(w);
        w.setHome(home);
        return this;
    }

    /**
     * sets father for men
     * There is only one father at house
     * @param m
     * @return
     */
    public HouseBuilder setFather(Men m)
    {
        home.setFather(m);
        m.setHome(home);
        return this;
    }


    /**
     * adds children to the house
     * There could be many children in the house
     * @param person
     * @return
     */
    public HouseBuilder addChild(Child person)
    {
        home.addChild(person);
        person.setHome(home);
        return this;
    }

    /**
     * Adds pet to the house
     * There could be many pets in the house
     * @param pet
     * @return
     */
    public HouseBuilder addPet(Pet pet)
    {
        home.addPet(pet);
        return this;
    }

}
