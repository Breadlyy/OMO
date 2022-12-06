import home.Floor;
import home.Home;
import home.Room;
import home.sensor.Sensor;
import home.stuff.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            List<Stuff> stuff = new ArrayList<>();
            Stuff stuff1 = new Fridge();
            Stuff stuff2 = new Microwave();
            Stuff stuff3 = new Oven();
            Stuff stuff4 = new Tap();
            stuff.add(stuff1);
        stuff.add(stuff2);
        stuff.add(stuff3);
        stuff.add(stuff4);
        Room room = new Room(2,3,4, new Floor(Home.getExample("1"), 1));
        room.setStuff(stuff);
        Room.Iterator iterator = room.getIterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.hasNext());
            System.out.println(iterator.next());
        }

    }
}
