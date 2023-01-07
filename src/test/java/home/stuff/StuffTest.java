package test.java.home.stuff;

import main.java.food.Food;
import main.java.home.stuff.Fridge;
import main.java.home.stuff.Microwave;
import main.java.home.stuff.Oven;
import main.java.home.stuff.Window;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class StuffTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void microvaweTurnsOffAutomaticallyTest()
    {
        Microwave m = new Microwave();
        m.start();
        assertTrue(m.active());
        m.run();
        m.run();
        m.run();
        m.run();
        m.run();
        m.run();
        assertFalse(m.active());
    }

    @Test
    public void putInFridgeMakesItNonEmptyTest()
    {
        Fridge f = new Fridge();
        assertTrue(f.empty());
        f.put(new Food());
        assertFalse(f.empty());
    }

    @Test
    public void eatRemovesFoodFromFridgeTest() {

        Food food = new Food();
        Fridge fridge = new Fridge();
        fridge.put(food);
        assertFalse(fridge.empty());
        fridge.eat(food);
        assertTrue(fridge.empty());
    }


    @Test
    public void ovenConsumesEnergyTest()
    {
        Oven oven = new Oven();
        oven.turnOn();
        oven.run();
        assertEquals("Oven 0 consumed 25.0 isactive true broken false", oven.generateReport());
    }

    @Test
    public void windowOpensAndConsumesEnergyTest()
    {
        Window w = new Window();
        w.open();
        assertTrue(w.isOpened());
        assertEquals("Window 0 consumed 7.0 opened", w.generateReport());
    }

}
