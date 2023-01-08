package test.java.home.stuff;

import main.java.events.Fire;
import main.java.events.GasLeak;
import main.java.events.ShortCircuit;
import main.java.home.sensor.Fuse;
import main.java.home.sensor.GasSensor;
import main.java.home.sensor.SmokeDetector;
import main.java.home.stuff.*;
import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

import java.awt.*;

import static org.junit.Assert.assertEquals;
@Testable
public class EventsTest
{
    @Test
    public void fireSensorTest_fireOccur_smokeDetectorDetectingStuffReflect()
    {
        Oven oven = new Oven();
        Fire fire = new Fire();
        SmokeDetector smokeDetector = new SmokeDetector();
        smokeDetector.add(oven);
        oven.powerOn();
        fire.attachSensor(smokeDetector);
        fire.occur();
        assertEquals(oven.getState(), StuffState.getOff());
        System.out.println();
    }
    @Test
    public void fuseTest_shortCircuitTestOccur_fuseDetectingStuffTReflectTest()
    {
        Fridge fridge = new Fridge();
        Fuse fuse = new Fuse();
        ShortCircuit shortCircuit = new ShortCircuit();
        fuse.add(fridge);
        fridge.powerOn();
        shortCircuit.attachSensor(fuse);
        shortCircuit.occur();
        assertEquals(fridge.getState(), StuffState.getOff());
    }


}
