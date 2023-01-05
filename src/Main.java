import animals.Pet;
import events.Event;
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

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        EventInstructionFrame instructionPanel = new EventInstructionFrame();
        window.add(instructionPanel);

        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        instructionPanel.start();

/*
        while (true)
        {

            /*
            * Do events fire, etc.



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

        }*/

    }
}
