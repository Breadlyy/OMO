import animals.Pet;
import events.Fire;
import home.Floor;
import home.Home;
import home.Room;
import home.sensor.Sensor;
import home.sensor.SmokeDetector;
import home.stuff.*;
import humans.Child;
import humans.Human;
import humans.Men;
import parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Parser parser = new Parser();
        Home h = parser.getHome();

        while (true)
        {

            /*
            * Do events fire, etc.
             */
             for(Stuff s = h.iterator.begin(); h.iterator.hasNext(); s = h.iterator.next())
            {
                s.run();
                System.out.println(h.generateReport(s));
            }
            for(Pet pet:  h.getPets())
            {
                pet.run();
            }
            for(Child child: h.getChildren())
            {
                child.run();
            }
            h.getFather().run();
            h.getMother().run();

        }

    }
}
