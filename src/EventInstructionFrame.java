import animals.Pet;
import home.Home;
import home.stuff.Stuff;
import humans.Child;
import parser.Parser;

import javax.swing.*;
import java.awt.*;

public class EventInstructionFrame extends JPanel implements Runnable {
    KeyHandler keyh = new KeyHandler();
    Home home;
    int reportcount = 0;

    public EventInstructionFrame() {
        this.setPreferredSize(new Dimension(200, 200));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
        this.setFocusable(true);
    }

    public void start() {
        synchronized (this) {
            Parser p = new Parser();
            home = p.getHome();
        }
        Thread runThread = new Thread(this);
        runThread.start();
    }

    @Override
    public void run() {

        int cooldown = 0;
        while (true) {
            reportcount++;
            if (cooldown == 0) {
                if (keyh.fire) {
                    home.getFire().occur();
                    cooldown = 10;
                } else if (keyh.wind) {
                    home.getWindBlow().occur();
                    cooldown = 10;
                } else if (keyh.flood) {
                    home.getWaterLeak().occur();
                    cooldown = 10;
                } else if (keyh.fourth) {
                    home.getShortCircuit().occur();
                    cooldown = 10;
                }
            }
            else {cooldown--;}

            for(Stuff it = home.iterator.begin();it!=null ; it = home.iterator.next()) it.run();

            for(Pet pet:  home.getPets())
            {
                pet.run();
            }
            for(Child child: home.getChildren())
            {
                child.run();
            }
            home.getFather().run();
            home.getMother().run();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("--------------------");
            if(reportcount==5) {
                System.out.println("REPORT");
                System.out.println(home.generateReport());
                System.out.println("--------------------");
                reportcount=0;
            }
        }
    }
}
