package test.java.home.stuff;

import main.java.home.stuff.Tap;
import main.java.home.stuff.Window;
import main.java.humans.Adult;
import main.java.humans.Child;
import main.java.humans.Men;
import main.java.tasks.CloseTapTask;
import main.java.tasks.CloseWindowTask;
import main.java.tasks.PlayTask;
import main.java.tasks.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import javax.annotation.concurrent.ThreadSafe;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
@Testable
public class TaskTest
{
    private Adult adult;
    private Child child;
    private Tap tap;
    private Window window;

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;


    @Before
    public void constructor()
    {
        adult = new Men("Name", "Surname", 1);
        child = new Child("childName", "childSurname", 1232);
        tap = new Tap(5);
        window = new Window();
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
    public void playWithChildTaskTest()
    {
        Task t = new PlayTask(adult, 1, 1, child);
        t.run();
        assertEquals("Name played with childName\r\n",outContent.toString());
    }

    @Test
    public  void closeWintowTest()
    {
        Task t = new CloseWindowTask(adult, 1, 1, window);
        window.open();
        assertTrue(window.isOpened());
        t.run();
        assertFalse(window.isOpened());
    }

    @Test
    public void closeTapTest()
    {
        Task t = new CloseTapTask(adult, 1, 1, tap);
        tap.turnOn();
        assertTrue(tap.active());
        t.run();
        assertFalse(tap.active());
    }
}
