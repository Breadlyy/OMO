package main.java;

import javax.swing.*;
import java.awt.*;

public class Main {
    Image inst = new ImageIcon("src/instruction.png").getImage();
    public void paint(Graphics g)
    {
        g.drawImage(inst, 0, 0, null);
    }
    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setSize(200, 200);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);

        EventInstructionFrame instructionPanel = new EventInstructionFrame();
        window.add(instructionPanel);


        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        

        instructionPanel.start();


    }
}
