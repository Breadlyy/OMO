package home.sensor;

import events.*;
import home.stuff.Stuff;

import java.util.List;
import java.util.Random;

public class Sensor {
    protected List<Stuff> stuff;

    public void notifySensor()
    {
        for(Stuff s: stuff)
        {
            s.notifyStuff();
        }
    }



    /*public Sensor()
    {
       this.waterSensor = new WaterSensor();
       this.fuse = new Fuse();
       this.windSensor = new WindSensor();
       this.gasSensor = new GasSensor();
       this.smoke_dec = new SmokeDetector();
        eventOccur();
    }
        private IEvent event;
        Random random = new Random();
        int num;
        private ISensor waterSensor;
        private ISensor windSensor;
        private ISensor gasSensor;
        private ISensor fuse;
        private ISensor smoke_dec;
        public void setEvent(IEvent event) {
                this.event = event;
        }
        public void eventOccur()
        {
            num = this.random.nextInt(1);
            if(num == 2) setEvent(new WaterLeak());
            if(num == 3) setEvent(new GasLeak());
            if(num == 2) setEvent(new ShortCircuit());
            if(num == 0) setEvent(new WindBlow());
            if(num == 4) setEvent(new Fire());
            triggerSomeSensor();
        }
        public void triggerSomeSensor() {
            if(event instanceof WaterLeak) waterSensor.triggered();
            else if(event instanceof GasLeak) gasSensor.triggered();
            else if(event instanceof WindBlow) windSensor.triggered();
            else if(event instanceof ShortCircuit) fuse.triggered();
            else if(event instanceof SmokeDetector) smoke_dec.triggered();
        }*/
}
