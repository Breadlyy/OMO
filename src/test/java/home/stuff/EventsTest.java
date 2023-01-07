package test.java.home.stuff;

import main.java.events.Fire;
import main.java.events.GasLeak;
import main.java.events.ShortCircuit;
import main.java.home.sensor.Fuse;
import main.java.home.sensor.GasSensor;
import main.java.home.sensor.SmokeDetector;
import main.java.home.stuff.*;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class EventsTest
{
    @Test
    public void FireOccurSmokeDetectorDetectingStuffReflectTest()
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
    public void ShortCircuitOccurFuseDetectingStuffTReflectTest()
    {
        Fridge fridge = new Fridge();
        Fuse fuse = new Fuse();
        ShortCircuit shortCircuit = new ShortCircuit();
        fuse.add(fridge);
        fridge.powerOn();
        shortCircuit.attachSensor(fuse);
        shortCircuit.occur();
        assertEquals(fridge.getState(), StuffState.getOff());
        System.out.println();
    }
    @Test
    public void MultipleStuff()
    {
        Fridge fridge = new Fridge();
        Oven oven = new Oven();
        GasHeater gasHeater = new GasHeater();
        Microwave microwave = new Microwave();
        GasSensor gasSensor = new GasSensor();
        Fuse fuse = new Fuse();
        SmokeDetector smokeDetector = new SmokeDetector();
        Fire fire = new Fire();
        ShortCircuit shortCircuit = new ShortCircuit();
        GasLeak gasLeak = new GasLeak();
        smokeDetector.add(microwave);
        gasSensor.add(gasHeater);
        fuse.add(microwave);
        smokeDetector.add(oven);
        fire.attachSensor(smokeDetector);
        shortCircuit.attachSensor(fuse);
        gasLeak.attachSensor(gasSensor);
        fridge.powerOn();
        oven.powerOn();
        microwave.powerOn();
        gasHeater.powerOn();
        fire.occur();
        System.out.println();
        assertEquals( StuffState.getOff(), microwave.getState());
        assertEquals(StuffState.getOff(),oven.getState());
        assertEquals( StuffState.getIdle(),fridge.getState());
        assertEquals( StuffState.getIdle(),gasHeater.getState());
        oven.powerOn();

        shortCircuit.occur();
        assertEquals( StuffState.getOff(),fridge.getState());
        assertEquals( StuffState.getIdle(),oven.getState());
        assertEquals( StuffState.getOff(),microwave.getState());
        assertEquals( StuffState.getIdle(),gasHeater.getState());
        gasLeak.occur();
        fire.occur();
        assertEquals( StuffState.getOff(),fridge.getState());
        assertEquals( StuffState.getOff(),gasHeater.getState());
        assertEquals( StuffState.getOff(),microwave.getState());
        assertEquals( StuffState.getOff(),gasHeater.getState());
    }
}
