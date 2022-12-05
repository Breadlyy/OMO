package home;

import animals.Pet;
import humans.Human;

import java.time.LocalDateTime;
import java.util.List;

public class Home {
    private static Home home;
    private List<Human> human;
    private List<Pet> pets;
    private List<Floor> floors;
   // public String values;
    private Home(String values) {
        this.values = values;
    }
    public static Home getExample(String values) {

        if (home == null) {

            home = new Home(values);

        }
        return home;

    }
}
