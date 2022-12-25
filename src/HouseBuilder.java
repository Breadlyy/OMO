import animals.Pet;
import home.Floor;
import home.Home;
import humans.Human;

public class HouseBuilder
{
    Home home;

    HouseBuilder addFloor(Floor floor)
    {
        home.addFloor(floor);
        return this;
    }

    HouseBuilder addHuman(Human person)
    {
        home.addHuman(person);
        return this;
    }

    HouseBuilder addPet(Pet pet)
    {
        home.addPet(pet);
        return this;
    }

    Home build()
    {
        return home;
    }
}
