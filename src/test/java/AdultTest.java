package test.java;

import main.java.animals.Cat;
import main.java.home.HouseBuilder;
import main.java.food.Food;
import main.java.home.Floor;
import main.java.home.Home;
import main.java.home.Room;
import main.java.home.stuff.Fridge;
import main.java.humans.Adult;
import main.java.humans.Child;
import main.java.humans.Men;
import main.java.tasks.FeedPetTask;
import main.java.tasks.PlayTask;
import main.java.tasks.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class AdultTest
{
    Adult sut;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void constructor()
    {
        sut = new Men("Name", "Surname", 1);
    }

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
    public void enqueueTaskTest_AddsTaskToQueue()
    {
        Task t = new FeedPetTask(sut, 2, 2, new Cat());
        sut.enqueueTask(t);
        assertEquals(sut.getTask(),t);
    }

    @Test
    public void enqueueTaskWithPriorityTest_FirstWithHigherPriority()
    {
        Task t0 = new FeedPetTask(sut, 2, 1, new Cat());

        Task t = new FeedPetTask(sut, 2, 2, new Cat());
        Task t2 = new FeedPetTask(sut, 2, 3, new Cat());

        sut.enqueueTask(t);
        sut.enqueueTask(t2);
        sut.enqueueTask(t0);
        assertEquals(sut.getTask(),t2);
    }

    @Test
    public void playWithChildTest()
    {
        Child c = new Child("Chld", "srname", 123);
        sut.playWith(c);
        assertEquals("Name played with Chld\r\n", outContent.toString());
    }

    @Test
    public void runTest_enqueuedTask_doesTask()
    {
        Child c = new Child("Chld", "srname", 123);
        sut.enqueueTask(new PlayTask(sut, 2, 2, c));
        sut.run();
        assertEquals("Name got task PlayTask\r\nName played with Chld\r\n", outContent.toString());
    }

    @Test
    public void runTest_enqueuedTask_busyAfterDoingTask()
    {
        Child c = new Child("Chld", "srname", 123);
        sut.enqueueTask(new PlayTask(sut, 2, 2, c));
        sut.run();
        sut.run();
        assertEquals("Name got task PlayTask\r\nName played with Chld\r\nName is busy\r\n", outContent.toString());
    }

    @Test
    public void goForFoodTest_emptyFrigde_nonEmptyFridge()
    {
        Fridge f = new Fridge();
        assertTrue( f.empty());
        sut.goForFood(f);
        assertFalse(f.empty());
    }


    /**
     * has to be started separately. Home is singleton, fridges are added before
     */
    @Test
    public void eatTest_noFridgesAtHome_asksWhy()
    {
        HouseBuilder builder = new HouseBuilder();
        Home h = builder.getHome();
        sut.setHome(h);
        sut.eat();
        assertEquals("Why don't we have fridges?\r\n", outContent.toString());
    }

    @Test
    public void eatTest_noFoodInFridge_addsNewTasks()
    {
        HouseBuilder builder = new HouseBuilder();
        Home h = builder.getHome();
        Floor f = new Floor(h, 1);
        Room r = new Room(1,2,3,f);
        r.addStuff(new Fridge());
        f.addRoom(r);
        builder.addFloor(f);
        sut.setHome(h);

        sut.eat();
        assertNotEquals(sut.getTask(), null);
    }

    @Test
    public void eatTest_foodInFridge_eats()
    {
        HouseBuilder builder = new HouseBuilder();
        Home h = builder.getHome();
        Floor f = new Floor(h, 1);
        Room r = new Room(1,2,3,f);
        Fridge fr = new Fridge();
        fr.put(new Food());
        r.addStuff(fr);
        f.addRoom(r);
        builder.addFloor(f);
        sut.setHome(h);

        sut.eat();
        assertEquals("Name moved to floor 1\r\n" +
                "Name ate Food from fridge 0\r\n" +
                "Adult Name ate\r\n", outContent.toString());
    }
}
