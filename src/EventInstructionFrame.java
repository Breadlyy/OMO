import home.Home;
import parser.Parser;

import javax.swing.*;
import java.awt.*;

public class EventInstructionFrame extends JPanel implements Runnable {
    KeyHandler keyh = new KeyHandler();
    Home home;

    public EventInstructionFrame() {
        this.setPreferredSize(new Dimension(200, 200));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
        this.setFocusable(true);
    }

    public void start() {
        Parser p = new Parser();
        home = p.getHome();
        Thread runThread = new Thread(this);
        runThread.start();
    }

    @Override
    public void run() {
        int cooldown = 0;
        while (true) {
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
            if (cooldown == 0) System.out.println("running");
            else cooldown--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        home.getRandomPerson().run();
        }
    }
}
