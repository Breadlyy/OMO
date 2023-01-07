package main.java;

import main.java.animals.Pet;
import main.java.home.Home;
import main.java.home.stuff.Stuff;
import main.java.humans.Child;
import main.java.parser.Parser;

import javax.swing.*;
import java.awt.*;

/**
 * window that will listen to keys to perform events
 */
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

    /**
     * start simultaion
     */
    public void start() {
        synchronized (this) {
            Parser p = new Parser();
            home = p.getHome();
        }
        Thread runThread = new Thread(this);
        runThread.start();
    }

    /**
     * main loop
     */
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
                home.generateReport();
                reportcount=0;
            }
        }
    }
}
