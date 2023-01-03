import events.Fire;
import home.Floor;
import home.Home;
import home.Room;
import home.sensor.Sensor;
import home.sensor.SmokeDetector;
import home.stuff.*;
import humans.Human;
import humans.Men;
import parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Parser p = new Parser();
        Home h = p.getHome();
        while (true)
        {

        }
        Stuff fridge = new Fridge();
        fridge.run();
        System.out.println();
    }
}
